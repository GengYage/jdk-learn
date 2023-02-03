package org.yage.excel;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.enums.CellExtraTypeEnum;
import com.alibaba.excel.metadata.CellExtra;
import com.alibaba.excel.support.ExcelTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

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

            if (cellExtra == null) {
                return;
            }

            // 开始行
            Integer firstRowIndex = cellExtra.getFirstRowIndex();
            Integer lastRowIndex = cellExtra.getLastRowIndex();
            Integer rowIndex = cellExtra.getRowIndex();
            Map<Integer, String> cellMap = data.get(rowIndex);
            String name = null;
            if (CollectionUtil.isNotEmpty(cellMap)) {
                name = cellMap.get(0);
            }

            // 兼容小可爱
            if (lastRowIndex > data.size()) {
                lastRowIndex = data.size() - 1;
            }

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
}

