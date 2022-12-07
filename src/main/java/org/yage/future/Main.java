package org.yage.future;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: Yage
 * @create: 2022-10-11 09:44
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        long l = System.currentTimeMillis();
        System.out.println("========");
        List<String> test = rpc(executor);
        System.out.println("========");
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
        System.out.println("========");
        test.forEach(System.out::println);
        System.out.println("========");
        long l2 = System.currentTimeMillis();
        circleRpc(executor);
        long l3 = System.currentTimeMillis();
        System.out.println();
        System.out.println("========");
        System.out.println(l3 - l2);
        executor.shutdown();
    }

    // 调用两个rpc接口,不分先后顺序
    public static List<String> rpc(ExecutorService e) {
        CompletableFuture<List<Integer>> intJob = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }

            return Arrays.asList(1, 2, 3, 4, 5, 6);
        }, e);

        CompletableFuture<List<String>> strJob = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }

            return Arrays.asList("7", "8", "9", "10");
        }, e);

        CompletableFuture<List<String>> resultJob = strJob.thenCombineAsync(intJob, (strList, intList) -> {
            // 尴尬 unsupported Operation
            ArrayList<String> result = new ArrayList<>(strList.size() + intList.size());
            result.addAll(strList);
            List<String> collect = intList.stream().map(String::valueOf).collect(Collectors.toList());
            result.addAll(collect);
            return result;
        }, e);

        return resultJob.exceptionally(ex -> {
            ex.printStackTrace();
            // 异常返回空列表
            return Collections.emptyList();
        }).join();
    }

    public static void circleRpc(ExecutorService executor) {
        @SuppressWarnings("unchecked")
        CompletableFuture<Integer>[] completableFutures = Stream.generate(new Fib()).limit(10).map(param -> CompletableFuture.supplyAsync(() -> param, executor)
                .thenApplyAsync(fib -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return fib;
                }, executor).whenCompleteAsync((v, ex) -> {
                    if (ex != null) {
                        ex.printStackTrace();
                    }
                    System.out.printf(v + " ");
                }, executor)).toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(completableFutures).join();
    }

    static class Fib implements Supplier<Integer> {
        int count = 0;

        @Override
        public Integer get() {
            return fid(count++);
        }

        int fid(int num) {
            if (num < 2) {
                return 1;
            } else {
                return fid(num - 2) + fid(num - 1);
            }
        }
    }

}
