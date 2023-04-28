package org.yage.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: Yage
 * @create: 2023-04-26 14:41
 */
@Slf4j
public class ListToTreeUtils {
    @Data
    @AllArgsConstructor
    static class Dep {
        private Long id;
        private String name;
        private Long pid;
        private Integer order;
    }

    @Data
    static class Result {
        private Dep value;
        private List<Dep> children;
    }

    public static List<Dep> getList() {
        ArrayList<Dep> deps = new ArrayList<>();
        deps.add(new Dep(1L, "根部门", null, 0));
        deps.add(new Dep(2L, "一级部门", 1L, 1));
        deps.add(new Dep(3L, "一级部门", 1L, 1));
        deps.add(new Dep(4L, "二级部门", 3L, 2));
        deps.add(new Dep(5L, "三级部门", 4L, 3));
        deps.add(new Dep(6L, "二级部门", 2L, 2));

        return deps;
    }

    public static void main(String[] args) {
        List<Dep> list = getList();
        Map<Long, Dep> map = list.stream()
                .collect(Collectors.toMap(Dep::getPid,
                        value -> value,
                        (oldValue, newValue) -> newValue));

        log.info("map: {}", map);
        Result result = new Result();
        // 没有父部门的就是根部门
        result.setValue(map.get(null));
    }
}
