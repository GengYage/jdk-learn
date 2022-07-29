package org.yage.stream;

import java.util.function.Consumer;

/**
 * T 入参
 * OUT 输入给下一个节点的类型
 *
 * @author: Yage
 * @create: 2022-07-27 18:37
 */
public interface Sink<T> extends Consumer<T> {

    @Override
    void accept(T t);

    abstract class ChainedReference<T, OUT> implements Sink<T> {
        protected final Sink<OUT> downstream;

        protected ChainedReference(Sink<OUT> downstream) {
            this.downstream = downstream;
        }
    }
}
