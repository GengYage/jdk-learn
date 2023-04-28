package org.yage.juc.unsafe;

import lombok.extern.slf4j.Slf4j;
import org.yage.lambda.User;

import java.lang.reflect.Field;

/**
 * @author: Yage
 * @create: 2023-04-10 19:10
 */
@Slf4j
public class Main {
    private static final sun.misc.Unsafe U;
    private static final long ABASE;
    private static final int ASHIFT;

    static {
        try {
            Field field = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            U = (sun.misc.Unsafe) field.get(null);
            Class<?> ak = double[].class;
            ABASE = U.arrayBaseOffset(ak);
            int scale = U.arrayIndexScale(ak);
            log.info("scale: {}", scale);
            if ((scale & (scale - 1)) != 0)
                throw new Error("data type scale not a power of two");
            ASHIFT = 31 - Integer.numberOfLeadingZeros(scale);

            log.info("ABASE: {}", ABASE);
            log.info("ASHIFT: {}", ASHIFT);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        User[] users = new User[10];
//        System.out.println(U.getObjectVolatile(users, ((long) 0 << ASHIFT) + ABASE));
    }
}
