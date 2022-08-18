package org.yage;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("a","b");

        Long a = null;
        map.get("aa");
        map.remove("aa");
        System.out.println(a);
        System.out.println(map);
    }
}