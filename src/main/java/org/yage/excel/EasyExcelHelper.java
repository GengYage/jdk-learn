package org.yage.excel;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.enums.CellExtraTypeEnum;
import com.alibaba.excel.metadata.CellExtra;
import com.alibaba.excel.support.ExcelTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Yage
 * @create: 2023-02-02 17:48
 */
@Slf4j
public class EasyExcelHelper<T> {
    public Map<String, Map<String, List<BigDecimal>>> getList(InputStream inputStream, Integer sheetNo, Integer headRowNumber) {
        EasyExcelListener listener = new EasyExcelListener(headRowNumber);
        try {
            EasyExcelFactory.read(inputStream, listener)
                    .excelType(ExcelTypeEnum.XLSX)
                    .extraRead(CellExtraTypeEnum.MERGE)
                    .sheet(sheetNo)
                    .headRowNumber(headRowNumber)
                    .doRead();
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        List<CellExtra> extraMergeInfoList = listener.getExtraMergeInfoList();
        if (CollectionUtils.isEmpty(extraMergeInfoList)) {
            return null;
        }

        return parse(listener.getData(), extraMergeInfoList);
    }

    private Map<String, Map<String, List<BigDecimal>>> parse(List<Map<Integer, String>> data, List<CellExtra> extraMergeInfoList) {

        Map<String, Map<String, List<BigDecimal>>> nameProjectTimes = new HashMap<>();
        extraMergeInfoList.forEach(cellExtra -> {
            // 开始行
            Integer firstRowIndex = cellExtra.getFirstRowIndex();
            Integer lastRowIndex = cellExtra.getLastRowIndex();

            if (lastRowIndex >= data.size()) {
                lastRowIndex = data.size() - 1;
            }

            if (firstRowIndex >= data.size()) {
                return;
            }

            String name = data.get(firstRowIndex).get(0);

            log.info(name);
            if (StrUtil.isNotBlank(name)) {
                fillData(nameProjectTimes, name, data, firstRowIndex, lastRowIndex);
            } else {
                log.info("ext: {}", cellExtra);
            }

        });

        return nameProjectTimes;
    }

    private void fillData(Map<String, Map<String, List<BigDecimal>>> nameProjectTimes, String name, List<Map<Integer, String>> data, Integer firstRowIndex, Integer lastRowIndex) {
        for (int i = firstRowIndex; i <= lastRowIndex; i++) {
            Map<Integer, String> row = data.get(i);

            if (CollectionUtil.isEmpty(row)) {
               continue;
            }

            Map<String, List<BigDecimal>> projectTimes = nameProjectTimes.computeIfAbsent(name, key -> new HashMap<>());

            if (row.get(2) != null) {
                List<BigDecimal> floats = projectTimes.computeIfAbsent(row.get(2), key -> new ArrayList<>());

                String s = row.get(5);
                if (s != null) {
                    floats.add(new BigDecimal(row.get(5)));
                }
            }
        }
    }


    private String getName(Integer start, Integer end, List<Map<Integer, String>> data) {
        String name = null;
        for (int i = start; i <= end; i++) {
            name = data.get(i).get(0);
            if (StrUtil.isNotBlank(name)) {
                return name;
            }
        }
        return null;
    }

}

