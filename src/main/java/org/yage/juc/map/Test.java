package org.yage.juc.map;

import org.yage.utils.Utils;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: Yage
 * @create: 2023-05-05 19:15
 */
public class Test {
    // 扩容阈值为6

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> MAP = new ConcurrentHashMap<>(4);

        Utils.StringGenerate generate = new Utils.StringGenerate();

        // 生成10个hashCode一样的key
        List<String> collect = Stream.generate(generate)
                .limit(10)
                .collect(Collectors.toList());

        int count = 0;
        for (String s : collect) {
            count++;
            MAP.put(s, s);
        }

    }
}
