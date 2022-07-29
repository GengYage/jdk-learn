package com.yage.stream;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

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
}
