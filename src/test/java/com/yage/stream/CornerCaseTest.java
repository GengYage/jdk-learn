package com.yage.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author: Yage
 * @create: 2022-07-29 09:59
 */
public class CornerCaseTest {
    @Test
    public void countTest() {
        // count 会短路流
        // jdk8之后 只要中间节点都是不会改变元素数据量的都不会被执行
        long count1 = IntStream.range(1, 10).peek(System.out::println).count();
        System.out.println("=========");
        long count2 = IntStream.range(1, 10).mapToObj(String::valueOf).peek(System.out::println).count();
        System.out.println("=========");
        System.out.println(count1);
        System.out.println(count2);
    }

    @Test
    public void mapVsFlatMapTest() {
        Stream<String> strFlatMapStream = Stream.of("a,b,c,d,e,f");

        // flatMap 将元素转换为流，会更改下面节点的sourceStage
        // 可以理解为flatMap变成了数据源
        strFlatMapStream.flatMap(str -> {
                    String[] split = str.split(",");
                    return Arrays.stream(split);
                }).peek(s -> System.out.printf("%s,", s))
                .filter(c -> c.equals("a"))
                .forEach(s -> System.out.printf("foreach(%s),", s));

        System.out.print("\n=========\n");

        Stream<String> strMapStream = Stream.of("a,b,c,d,e,f");
        // map 将元素转换为另一个类型,并将该元素传入下一个节点
        // 不会改变下面几点的sourceStage
        strMapStream.map(str -> str.split(","))
                .peek(System.out::println)
                .forEach(array -> {
                    for (String s : array) {
                        System.out.printf("%s,", s);
                    }
                    System.out.print("\n");
                });
    }
}
