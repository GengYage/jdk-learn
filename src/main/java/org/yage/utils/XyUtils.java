package org.yage.utils;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: Yage
 * @create: 2023-03-27 11:24
 */
public class XyUtils {
    public static void generateSql() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("/Users/it/Documents/a.txt"), StandardCharsets.UTF_8);

        ArrayList<Map<String, Object>> allUsers = new ArrayList<>(18000);

        bufferedReader.lines().forEach(line -> {
            try {
                if (StrUtil.isBlank(line)) {
                    return;
                }
                Map<String, Object> stringObjectMap = objectMapper.readValue(line, new TypeReference<Map<String, Object>>() {
                });
                @SuppressWarnings("unchecked")
                List<Map<String, Object>> content = (List<Map<String, Object>>) stringObjectMap.get("content");
                allUsers.addAll(content);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });

        Map<String, Map<String, Object>> collect = allUsers.stream()
                .collect(Collectors.toMap(map -> map.get("id") + "-" + map.get("phone") + "-" + map.get("userId"),
                        o -> o,
                        (a, b) -> a));

        System.out.println(collect.size());

        Set<String> adminSet = new HashSet<>();
        adminSet.add("1234512345");
        adminSet.add("13693099682");
        adminSet.add("12300000144");
        adminSet.add("12345678");
        adminSet.add("12341234");
        adminSet.add("1234567890123");
        adminSet.add("01085269800");

        List<String> updateSql = new ArrayList<>(15000);
        List<String> unDoUpdateSql = new ArrayList<>(15000);

        StringBuilder sb = new StringBuilder();

        collect.forEach((k, v) -> {
            // 不是管理员才拼接sql
            if (adminSet.add((String) v.get("phone"))) {
                sb.delete(0, sb.length());
                // todo
                sb.append(v.get("userId"));
                sb.append("';");
                updateSql.add(sb.toString());
                sb.delete(0, sb.length());
                // todo
                sb.append(v.get("userId"));
                sb.append("';");
                unDoUpdateSql.add(sb.toString());
            } else {
                System.out.println(v.get("phone"));
            }
        });

        System.out.println("update sql size: " + updateSql.size());
        System.out.println("rollback sql size: " + unDoUpdateSql.size());

        Files.write(Paths.get("/Users/it/Documents/update.sql"), updateSql, StandardCharsets.UTF_8);
        Files.write(Paths.get("/Users/it/Documents/rollback.sql"), unDoUpdateSql, StandardCharsets.UTF_8);
    }
}
