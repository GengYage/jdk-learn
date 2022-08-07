package org.yage.jvm;

/**
 * @author: Yage
 * @create: 2022-08-07 18:16
 */
public class FinalizeSavaSelf {
    public static FinalizeSavaSelf SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes, i am alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        // 将自身重新赋值给GC Root
        SAVE_HOOK = this;
    }

    public static void saveSelf() throws InterruptedException {
        SAVE_HOOK = null;
        // 手动触发gc
        System.gc();
        // finalize方法优先级很低，主线程等待一下
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeSavaSelf();
        saveSelf();
        saveSelf();
    }
}