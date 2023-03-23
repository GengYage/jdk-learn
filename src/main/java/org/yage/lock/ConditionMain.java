package org.yage.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Yage
 * @create: 2023-03-21 17:41
 */
@Slf4j
public class ConditionMain {
    static final ReentrantLock lock = new ReentrantLock();
    static final Condition condition = lock.newCondition();

    private static long count = 0L;


    public static void main(String[] args) {

        Runnable runnable = () -> {
            for (; ; ) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.info("{} 开始抢锁", Thread.currentThread().getName());
                lock.lock();
                log.info("{} 抢锁成功", Thread.currentThread().getName());
                count++;
                log.info("{}: count: {}", Thread.currentThread().getName(), count);

                // 只有A 有唤醒能力
                if (Thread.currentThread().getName().equals("A")) {
                    condition.signalAll();
                }

                try {
                    if (count < 100L) {
                        log.info("{}: 开始睡觉,释放锁", Thread.currentThread().getName());
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
        new Thread(runnable, "C").start();
        new Thread(runnable, "D").start();
        new Thread(runnable, "E").start();
    }
}
