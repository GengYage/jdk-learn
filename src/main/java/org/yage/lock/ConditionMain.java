package org.yage.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Yage
 * @create: 2023-03-21 17:41
 */
public class ConditionMain {
    static final ReentrantLock lock = new ReentrantLock();
    static final Condition condition = lock.newCondition();

    private static long count = 0L;


    public static void main(String[] args) {

        Runnable runnable = () -> {
            for (; ; ) {
                lock.lock();
                count++;
                System.out.println(Thread.currentThread().getName() + " " + count);
                condition.signal();

                try {
                    if (count < 100L) {
                        condition.await();
                    } else {
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };

        new Thread(runnable, "A").start();
        new Thread(runnable, "B").start();
    }
}
