package org.yage.juc.map;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: Yage
 * @create: 2023-03-30 18:51
 */
public class Main {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("hello", "world");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(null, "hello");
        hashMap.put(null, "world");
        System.out.println(hashMap);
        int a = 0x7fffffff;
        int b = 0b0001111111111111111111111111101;
        System.out.println(Integer.toBinaryString(b & a));
    }
}
