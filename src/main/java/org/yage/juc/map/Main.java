package org.yage.juc.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: Yage
 * @create: 2023-03-30 18:51
 */
public class Main {
    static int resizeStamp(int n) {
        return Integer.numberOfLeadingZeros(n) | (1 << (16 - 1));
    }

    static int sc(int n) {
        return resizeStamp(n) << 16;
    }

    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("Aa", "BB");
        map.get("AA");
        map.contains("AA");

        System.out.println(sc(16) + " " + Integer.toBinaryString(sc(16)));
        System.out.println((sc(16) + 1) + " " + Integer.toBinaryString(sc(16) + 1));
        System.out.println((sc(16) + 2) + " " + Integer.toBinaryString(sc(16) + 2));
        System.out.println((sc(16) + 65535) + " " + Integer.toBinaryString(sc(16) + 65535));
    }
}
