package org.yage.excel;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.util.*;

/**
 * @author: Yage
 * @create: 2023-02-02 17:42
 */
@Slf4j
public class ManDayCounter {
    static class NullKeySerializer extends StdSerializer<Object> {
        protected NullKeySerializer(Class<Object> t) {
            super(t);
        }
        public NullKeySerializer() {
            this(null);
        }
        @Override
        public void serialize(Object nullKey, JsonGenerator jsonGenerator, SerializerProvider unused)
                throws IOException {
            jsonGenerator.writeFieldName("");
        }
    }
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        OBJECT_MAPPER.getSerializerProvider().setNullKeySerializer(new NullKeySerializer());
    }

    public static final Map<String, List<String>> resultPeople = new HashMap<>();

    public static final Map<Integer, String> sheetNameMap = new HashMap<>();

    public static void main(String[] args) throws JsonProcessingException {

        File file = new File("/Users/it/Downloads/映射2021-基础服务组.xlsx");
        ExcelReaderBuilder excelReaderBuilder = EasyExcel.read(file);
        ExcelReader excelReader = excelReaderBuilder.build();
        List<ReadSheet> sheets = excelReader.excelExecutor().sheetList();
        for (ReadSheet sheet : sheets) {
            excelReader.read(sheet);

            sheetNameMap.put(sheet.getSheetNo(), sheet.getSheetName());
        }


//        for (int i = 3; i < 100; i++) {
//            forEach(i);
//        }

        forEach(2);

        log.info("可能填错的人: {}", OBJECT_MAPPER.writeValueAsString(resultPeople));
    }

    private static void forEach(int sheetIndex) {
        try (InputStream io = Files.newInputStream(new File("/Users/it/Downloads/映射2021-基础服务组.xlsx").toPath())) {
            EasyExcelHelper<Map<Integer, String>> helper = new EasyExcelHelper<>();
            Map<String, Map<String, List<BigDecimal>>> listData = helper.getList(io, sheetIndex, 0);
            validate(listData, sheetIndex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static void validate(Map<String, Map<String, List<BigDecimal>>> listData, int sheetIndex) throws JsonProcessingException {
        log.info("原始数据:{}", OBJECT_MAPPER.writeValueAsString(listData));

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

        // 都在一个集合就是没有填错的
        if (values.size() == 1) {
            return;
        }

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

        List<String> strings = resultPeople.computeIfAbsent(sheetNameMap.get(sheetIndex), k -> new ArrayList<>());
        strings.addAll(failPeople);
        log.info("可能填错的人: {}", OBJECT_MAPPER.writeValueAsString(failPeople));
    }
}
