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
        map.forEach((k, v) -> {
            System.out.println("key: " + k + ", value" + v);
        });

        System.out.println(sc(16) + " " + Integer.toBinaryString(sc(16)));
        System.out.println((sc(16) + 1) + " " + Integer.toBinaryString(sc(16) + 1));
        System.out.println((sc(16) + 2) + " " + Integer.toBinaryString(sc(16) + 2));
        System.out.println((sc(16) + 65535) + " " + Integer.toBinaryString(sc(16) + 65535));

        System.out.println(MAXIMUM_CAPACITY >>> 3 / 8);

//        deadLock();
    }
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    // sentinel
    // cluster
    private static final int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public static void deadLock() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        // 经典bug, 死锁
        map.computeIfAbsent("AaAa", key ->
                map.computeIfAbsent("BBBB", key2 -> 42));

        System.out.println(map.size());
    }

}
