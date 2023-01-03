package org.yage.threadlocal;

import java.lang.reflect.Field;

/**
 * @author: Yage
 * @create: 2023-01-04 19:25
 */
public class TestThreadLocal {
    private static final ThreadLocal<Integer> TL_1 = new ThreadLocal<>();
    private static final ThreadLocal<String> TL_2 = new ThreadLocal<>();
    private static final ThreadLocal<Long> TL_3 = new ThreadLocal<>();

    public static void main(String[] args) throws Exception {
        TL_1.set(1);
        TL_2.set("1");
        TL_3.set(1L);
        Field field = Thread.class.getDeclaredField("threadLocals");
        field.setAccessible(true);
        Object o = field.get(Thread.currentThread());
        System.out.println(o);
    }

}
