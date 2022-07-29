package com.yage.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
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

    @Test
    public void reduceTest() {
        Stream<Integer> intStream = Stream.of(1, 2, 3, 4);
        // 点进源码看
        Optional<Integer> reduce = intStream.reduce((x, y) -> {
            System.out.printf("x:%d ,y%d\n", x, y);
            return x + y;
        });

        reduce.ifPresent(sum -> System.out.printf("sum = %d\n", sum));
    }

    @Test
    public void groupByVsPartitioningByTest() {
        Stream<Integer> intStream = Stream.of(1, -1, 2, -2, 3, -3, 4, -4);
        // 根据条件分区
        Map<Boolean, List<Integer>> partition = intStream.collect(Collectors.partitioningBy(a -> a > 0));
        partition.forEach((key, value) -> {
            System.out.printf("key: %s, value: %s\n", key, Arrays.toString(value.toArray()));
        });

        System.out.println("======");
        Stream<Integer> intGroupByStream = Stream.of(1, 1, 2, 2, 3, 3, 4, 4);
        // 根据字段分组
        Map<Integer, List<Integer>> group = intGroupByStream.collect(Collectors.groupingBy(a -> a));
        group.forEach((key, value) -> {
            System.out.printf("key: %s, value: %s\n", key, Arrays.toString(value.toArray()));
        });

    }
}
