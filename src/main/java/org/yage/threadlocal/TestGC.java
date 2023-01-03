package org.yage.threadlocal;

import java.lang.ref.WeakReference;

/**
 * @author: Yage
 * @create: 2023-01-05 19:25
 */
public class TestGC {
    static ThreadLocal<int[]> T = new ThreadLocal<>();
    static WeakReference<String> weakReference = null;

    public static void main(String[] args) {
        testWeakReference();
//        testThreadLocal();
    }

    public static void testThreadLocal() {
        for (int i = 0; i < 8; i++) {
            new Thread(() -> {
                try {
                    // 4MB
                    int[] ints = new int[1024 * 1024];
                    T.set(ints);
                } catch (OutOfMemoryError e) {
                    System.out.println("OOM");
                }

                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }
    }

    public static void testWeakReference() {
        test1();
        System.out.println(weakReference.get());
        System.gc();
        System.out.println(weakReference.get());
    }

    public static void test1(){
        String str = new String("hello world");
        weakReference = new WeakReference<>(str);

        System.gc();

        System.out.println(weakReference.get());
    }
}
