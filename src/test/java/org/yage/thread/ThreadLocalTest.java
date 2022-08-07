package org.yage.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author: Yage
 * @create: 2022-08-03 16:06
 */
public class ThreadLocalTest {
    final static ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    @Test
    public void threadIndependent() throws InterruptedException {
        THREAD_LOCAL.set(Thread.currentThread().getId() + "-hello");
        new Thread(() -> {
            THREAD_LOCAL.set(Thread.currentThread().getId() + "-hello");
            System.out.println(THREAD_LOCAL.get());
        }).start();
        new Thread(() -> System.out.println(THREAD_LOCAL.get())).start();
        new Thread(() -> System.out.println(THREAD_LOCAL.get())).start();

        Thread.sleep(TimeUnit.MILLISECONDS.toMillis(10));
        System.out.println(THREAD_LOCAL.get());
    }
}
