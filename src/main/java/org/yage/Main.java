package org.yage;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(resizeStamp(0) + " " + Integer.toBinaryString(resizeStamp(0)) + " " + ((resizeStamp(0) << 16) + 2));
        System.out.println(resizeStamp(4) + " " + Integer.toBinaryString(resizeStamp(4)) + " " + ((resizeStamp(4) << 16) + 2));
        System.out.println(resizeStamp(8) + " " + Integer.toBinaryString(resizeStamp(8)) + " " + ((resizeStamp(8) << 16) + 2));
        System.out.println(resizeStamp(16) + " " + Integer.toBinaryString(resizeStamp(16)) + " " + ((resizeStamp(16) << 16) + 2));
        System.out.println(resizeStamp(32) + " " + Integer.toBinaryString(resizeStamp(32)) + " " + ((resizeStamp(32) << 16) + 2));
        System.out.println((resizeStamp(4) << 16) + " " + Integer.toBinaryString(resizeStamp(4) << 16) + " " + Integer.toBinaryString((resizeStamp(4) << 16) + 2));

        System.out.println(resizeStamp(16) + " " + Integer.toBinaryString(resizeStamp(16)) + " " + ((resizeStamp(16) << 16) + 2) + (resizeStamp(32) + 1));

        System.out.println(8 >>> 3);

        System.out.println("key".hashCode() + " " + Integer.toBinaryString("key".hashCode()));
        System.out.println(spread("key".hashCode()) + " " + Integer.toBinaryString(spread("key".hashCode())));
        print(106079>>>16);
        print(HASH_BITS);
    }


    static final int spread(int h) {
        return (h ^ (h >>> 16)) & HASH_BITS;
    }

    private static int RESIZE_STAMP_BITS = 16;
    static final int HASH_BITS = 0x7fffffff; // usable bits of normal node hash

    static final int resizeStamp(int n) {
        return Integer.numberOfLeadingZeros(n) | (1 << (RESIZE_STAMP_BITS - 1));
    }


    static void print(int value) {
        System.out.println(value + " " + Integer.toBinaryString(value));
    }
}