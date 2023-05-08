package org.yage.utils;

import cn.hutool.core.util.RandomUtil;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author: Yage
 * @create: 2023-04-07 17:30
 */
public class Utils {
    public static class StringGenerate implements Supplier<String> {
        @Override
        public String get() {
            StringBuilder sb = new StringBuilder();
            int concatCount = 100;
            for (int i = 0; i < concatCount; i++) {
                int i1 = RandomUtil.randomInt(2);
                String baseB = "BB";
                String baseA = "Aa";
                sb.append(i1 == 1 ? baseA : baseB);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        StringGenerate generate = new StringGenerate();

        Stream.generate(generate)
                .limit(10)
                .map(String::hashCode)
                .forEach(System.out::println);
    }
}
