package org.yage.juc.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: Yage
 * @create: 2023-03-27 15:57
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        countDownLatch.countDown();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            countDownLatch.countDown();
        }, "Son").start();

        new Thread(() -> {
            try {
                countDownLatch.await();
                System.out.println(Thread.currentThread().getName() + " ok");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "other1").start();

        new Thread(() -> {
            try {
                countDownLatch.await();
                System.out.println(Thread.currentThread().getName() + " ok");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "other2").start();

        countDownLatch.await();
    }
}
