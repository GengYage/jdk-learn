package org.yage.juc.collection;

import cn.hutool.core.util.RandomUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: Yage
 * @create: 2023-03-27 14:56
 */
public class Main {
    @Data
    @AllArgsConstructor
    static class Value {
        private String name;
        private String value;
    }

    static Map<String, Value> MAP = new ConcurrentHashMap<>();

    static {
        MAP.put("1", new Value("1", "a"));
        MAP.put("2", new Value("2", "b"));
        MAP.put("3", new Value("3", "c"));
    }

    // 结论 values返回的集合线程安全
    public static void main(String[] args) throws InterruptedException {
        Collection<Value> values = MAP.values();

        List<Thread> t = new ArrayList<>();
        t.add(new Thread(() ->
                values.forEach(v -> v.setValue(RandomUtil.randomString(5)))));

        t.forEach(Thread::start);

        // 如果一边遍历一边put呢？
        for (int i = 0; i < 10; i++) {
            MAP.put(RandomUtil.randomString(5), new Value("put", "put"));
        }

        TimeUnit.SECONDS.sleep(2);
        System.out.println(values);
    }
}
