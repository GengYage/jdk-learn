package org.yage.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author: Yage
 * @create: 2022-07-27 18:39
 */
public class ReferenceChain<R, Out> {

    // skin chain
    private final List<Supplier<Sink<R>>> sinkBuilders = new ArrayList<>();

    // current skin
    private final AtomicReference<Sink<?>> sinkReference = new AtomicReference<>();

    //filter
    public ReferenceChain<R, Out> filter(Predicate<R> predicate) {
        // 添加新节点 只有 test通过才会执行preSink的操作
        sinkBuilders.add(() -> {
            Sink<Out> prevSink = (Sink<Out>) sinkReference.get();

            // 不改变值类型，输入什么输出什么类型
            Sink.ChainedReference<R, Out> currentSink = new Sink.ChainedReference<R, Out>(prevSink) {
                @Override
                public void accept(R out) {
                    if (predicate.test(out)) {
                        downstream.accept((Out) out);
                    }
                }
            };

            sinkReference.set(currentSink);
            return currentSink;
        });

        // build模式
        return this;
    }

    public ReferenceChain<R, Out> map(Function<R, Out> function) {
        sinkBuilders.add(() -> {
            Sink<Out> prevSink = (Sink<Out>) sinkReference.get();

            // 改变值类型输入R,输出OUT
            Sink.ChainedReference<R, Out> currSink = new Sink.ChainedReference<R, Out>(prevSink) {
                @Override
                public void accept(R in) {
                    downstream.accept(function.apply(in));
                }
            };
            sinkReference.set(currSink);
            return currSink;
        });

        // build模式
        return this;
    }

    public void forEach(Collection<R> collection, Sink<R> consumer) {
        Spliterator<R> spliterator = collection.spliterator();
        sinkReference.set(consumer);
        Sink<R> stage = consumer;

        // 构建链
        for (int i = sinkBuilders.size() - 1; i >= 0; i--) {
            Supplier<Sink<R>> supplier = sinkBuilders.get(i);
            // 执行get方法才会出发链的构建
            stage = supplier.get();
        }
        Sink<R> finalStage = stage;

        // 从头到尾开始执行
        spliterator.forEachRemaining(finalStage);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(6);
        list.add(13);
        list.add(12);
        ReferenceChain<Integer, Integer> chain = new ReferenceChain<>();
        // filter -> map -> for each
        chain.filter(item -> item > 10)
                .map(item -> item * 2)
                .forEach(list, System.out::println);
    }
}
