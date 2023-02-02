package org.yage.excel;

import cn.hutool.core.collection.CollectionUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * @author: Yage
 * @create: 2023-02-02 17:42
 */
@Slf4j
public class ManDayCounter {
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        EasyExcelHelper<Map<Integer, String>> helper = new EasyExcelHelper<>();
        File file = new File("/home/isbest/Downloads/映射2022-基础服务组.xlsx");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        // 参数 文件流，sheet页号，头行号
        Map<String, Map<String, List<BigDecimal>>> listData = helper.getList(fileInputStream, 2, 0);
        validate(listData);
    }


    private static void validate(Map<String, Map<String, List<BigDecimal>>> listData) throws JsonProcessingException {
        if (CollectionUtil.isEmpty(listData)) {
            return;
        }
        Map<String, Map<String, String>> manDay = new HashMap<>();
        listData.forEach((k, v) -> {
            Map<String, String> projectManDay = manDay.computeIfAbsent(k, a -> new HashMap<>());

            v.forEach((k1, v1) -> {
                double sum = 0;
                for (BigDecimal aFloat : v1) {
                    sum += aFloat.doubleValue();
                }

                BigDecimal bigDecimal = new BigDecimal(sum);
                BigDecimal bigDecimal1q = bigDecimal.setScale(3, RoundingMode.HALF_UP);

                projectManDay.put(k1, bigDecimal1q.toString());
            });
        });

        log.info("{}", OBJECT_MAPPER.writeValueAsString(manDay));

        // 校验逻辑

        List<String> failPeople = new ArrayList<>(12);

        Set<String> re = new HashSet<>();
        Map<String, List<String>> validateMap = new HashMap<>();

        manDay.forEach((k, v) -> {
            double sum = 0;
            for (String value : v.values()) {
                sum += new BigDecimal(value).doubleValue();
            }

            BigDecimal bigDecimal = new BigDecimal(sum).setScale(3, RoundingMode.HALF_UP);

           validateMap.computeIfAbsent(bigDecimal.toString(), a -> new ArrayList<>())
                   .add(k);
        });

        // list 中多的人为正确的
        Collection<List<String>> values = validateMap.values();
        // 多数为正确的
        int maxSize = values.stream()
                .map(List::size)
                .max(Integer::compareTo)
                .orElse(100);

        for (List<String> value : values) {
            if (value.size() < maxSize) {
               failPeople.addAll(value);
            }
        }

        log.info("可能填错的人: {}", OBJECT_MAPPER.writeValueAsString(failPeople));
    }
}
