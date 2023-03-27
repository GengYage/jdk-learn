package org.yage.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Yage
 * @create: 2023-03-17 17:21
 */
public class FairLock {
    public static void main(String[] args) {

        String a = null;
        System.out.println(a);
        testRefer(a);
        System.out.println(a);
    }

    public static void testRefer(String a) {
        a = "hello";
    }

    public static void testFairLock() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock(true);
        lock.lock();
        // 除了lock方法其他的都和unlock一样
    }
}
