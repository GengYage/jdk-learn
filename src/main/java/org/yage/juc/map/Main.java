package org.yage.juc.map;

import org.yage.lambda.People;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author: Yage
 * @create: 2023-03-30 18:51
 */
public class Main {
    volatile People[] array = new People[5];


    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("hello", "world");
        HashMap<String, String> stringStringHashMap = new HashMap<>();

        System.out.println(offset(0, 0, 4));
        System.out.println(offset(1, 0, 4));
        System.out.println(offset(2, 0, 4));

        System.out.println();

        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.numberOfLeadingZeros(4));

        System.out.println();
        System.out.println(Integer.numberOfLeadingZeros(4 << -1));

        testVolatile();
    }

    /**
     * 获取偏移值
     *
     * @param i     索引
     * @param base  基地址
     * @param oSize 元素大小
     * @return i的地址
     */
    public static int offset(int i, int base, int oSize) {
        int ASHIFT = 31 - Integer.numberOfLeadingZeros(oSize);
        System.out.print(i + " " + ASHIFT + " ");
        int tmp;
        System.out.println((tmp = i << ASHIFT));
        return tmp + base;
    }

    // 测不出来
    public static void testVolatile() throws InterruptedException {
        Main main = new Main();
        for (int i = 0; i < 5; i++) {
            main.array[i] = new People(String.valueOf(i), (long) i);
        }

        new Thread(() -> {
            while (true) {
                People people = main.array[0];
                if (people.getName().equals("world")) {
                    break;
                } else {
                    System.out.println(people);
                }
            }
        }).start();

        main.array[0] = new People("hello", 1L);

        TimeUnit.SECONDS.sleep(1);
        main.array[0] = new People("world", 1L);

        TimeUnit.SECONDS.sleep(1);
    }

}
