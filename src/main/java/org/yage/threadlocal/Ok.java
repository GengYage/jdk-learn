package org.yage.threadlocal;

/**
 * @author: Yage
 * @create: 2023-01-09 19:40
 */
public class Ok {
    public static void main(String[] args) {

        // thread print local var
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                threadLocal.set("hello");
                try {
                    // do some things
                    System.out.println(Thread.currentThread().getId() + " done.");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    threadLocal.remove();
                }
            }).start();
        }
    }
}
