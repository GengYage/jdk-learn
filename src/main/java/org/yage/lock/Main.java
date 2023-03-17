package org.yage.lock;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

/**
 * @author: Yage
 * @create: 2023-03-14 16:38
 */
public class Main {

    public static final List<String> safeList = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
//        testLock();
//        testInterrupt();
        testLockInterrupt();
    }

    public static void testLockInterrupt() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        AtomicInteger interruptThreadCount = new AtomicInteger(0);
        Thread[] threads = new Thread[100];

        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(() -> {
                boolean needUnlock = true;
                try {
                    lock.lockInterruptibly();
                } catch (InterruptedException e) {
                    needUnlock = false;
                    System.out.println(Thread.currentThread().getName());
                }

                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("magic: " + needUnlock + ": " + Thread.currentThread().getName());
                    interruptThreadCount.addAndGet(1);
                }

                if (needUnlock) {
                    lock.unlock();
                }
            });
        }
        // 主线程先拿到锁
        lock.lock();
        TimeUnit.MILLISECONDS.sleep(10);

        Stream.of(threads).forEach(Thread::start);
        TimeUnit.MILLISECONDS.sleep(10);
        lock.unlock();
        // 中断唤醒所有子线程
        Stream.of(threads).forEach(Thread::interrupt);
        TimeUnit.SECONDS.sleep(2);
        System.out.println(interruptThreadCount);
    }

    public static void testLock() {
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 10; i++) {
            new Thread(() ->
                    add(lock, Thread.currentThread().getName())
            ).start();
        }

        System.out.println(Arrays.toString(safeList.toArray()));
    }

    private static void add(ReentrantLock lock, String value) {
        lock.lock();
        safeList.add(value);
        lock.unlock();
    }

    private static void testInterrupt() throws InterruptedException {
        Thread interrupted = new Thread(() -> {
            try {
                System.out.println("手动sleep");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("在sleep捕获到了异常");
            }

            if (Thread.currentThread().isInterrupted()) {
                System.out.println("中断标记位未被清空");
            } else {
                System.out.println("中断标记位被清空");
            }
        });

        interrupted.start();
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("手动中断");
        interrupted.interrupt();
    }
}
