package org.yage.gc;

import org.junit.jupiter.api.Test;

/**
 * @author: Yage
 * @create: 2022-08-08 19:22
 */
public class GcTest {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;
    private byte[] bigSize = new byte[21 * _1MB];

    @Test
    public void circleReferenceGcTest() {
        GcTest objA = new GcTest();
        GcTest objB = new GcTest();
        objB.instance = objA;
        objA.instance = objB;
        // 创建根不可达的循环引用
        objA = null;
        objB = null;

        System.gc();
    }
}
