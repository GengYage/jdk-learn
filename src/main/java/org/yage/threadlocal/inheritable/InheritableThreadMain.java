package org.yage.threadlocal.inheritable;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: Yage
 * @create: 2023-01-10 11:48
 */
public class InheritableThreadMain {
    static final InheritableThreadLocal<String> ITL = new InheritableThreadLocal<>();
    static final Executor EXECUTOR = Executors.newFixedThreadPool(1);

    public static void main(String[] args) throws Exception {
        ITL.set("throwable");

        // 这个方法执行完 所有的核心线程都会被创建
        EXECUTOR.execute(() -> {
            System.out.println(ITL.get());
        });

        ITL.set("doge");

        // doge 失效
        EXECUTOR.execute(() -> {
            System.out.println(ITL.get());
        });

        TimeUnit.SECONDS.sleep(Long.MAX_VALUE);
    }
}
