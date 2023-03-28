package org.yage.juc.countdownlatch;

//import sun.misc.Unsafe;

//import java.lang.reflect.Field;

/**
 * @author: Yage
 * @create: 2023-03-27 16:21
 */
public class CAS {
//    private static final Unsafe unsafe;
//    private static long stateOffset = 0;
//
//    static {
//        try {
//            Field field = Unsafe.class.getDeclaredField("theUnsafe");
//            field.setAccessible(true);
//            unsafe = (Unsafe) field.get(null);
//        } catch (Exception e) {
//            throw new RuntimeException("Unable to get Unsafe instance", e);
//        }
//
//        try {
//            stateOffset = unsafe.objectFieldOffset(AQS.class.getDeclaredField("state"));
//        } catch (Exception ignore) {
//        }
//    }
//
//    static class AQS {
//        private int state;
//    }


    public static void main(String[] args) {
//        // 服了
//        AQS aqs = new AQS();
//        boolean b = unsafe.compareAndSwapInt(aqs, stateOffset, 0, 1);
//        System.out.println(b);
//        System.out.println(aqs);
    }
}
