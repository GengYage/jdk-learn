package org.yage.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.enums.CellExtraTypeEnum;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellExtra;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author: Yage
 * @create: 2023-02-02 17:43
 */
@Slf4j
public class EasyExcelListener extends AnalysisEventListener<Map<Integer, String>> {
    /**
     * 数据
     */
    List<Map<Integer, String>> dataList = new ArrayList<>();
    /**
     * 正文起始行
     */
    private final Integer headRowNumber;
    /**
     * 合并单元格
     */
    private final List<CellExtra> extraMergeInfoList = new ArrayList<>();


    public EasyExcelListener(Integer headRowNumber) {
        this.headRowNumber = headRowNumber;
    }

    @Override
    public void invoke(Map<Integer, String> data, AnalysisContext context) {
        dataList.add(data);
    }

    /**
     * 读取额外信息：合并单元格
     */
    @Override
    public void extra(CellExtra extra, AnalysisContext context) {
        if (Objects.requireNonNull(extra.getType()) == CellExtraTypeEnum.MERGE) {
            if (extra.getRowIndex() >= headRowNumber) {
                extraMergeInfoList.add(extra);
            }
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("所有数据解析完成！");
    }

    /**
     * 返回解析出来的List
     */
    public List<Map<Integer, String>> getData() {
        return dataList;
    }

    /**
     * 返回解析出来的合并单元格List
     */
    public List<CellExtra> getExtraMergeInfoList() {
        return extraMergeInfoList;
    }
}
