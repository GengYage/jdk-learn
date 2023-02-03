package org.yage.excel;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.sax.handler.RowHandler;
import lombok.Builder;
import lombok.Data;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * ClassName:Test2
 * Package:com.bin.test
 * Description:
 *
 * @Author @Bin
 * @Date 2023/2/2-17:41
 * @Version: v1.0
 *
 *  <!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
 *         <dependency>
 *             <groupId>org.apache.poi</groupId>
 *             <artifactId>poi-ooxml</artifactId>
 *             <version>5.2.3</version>
 *         </dependency>
 *
 *
 *         <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
 *         <dependency>
 *             <groupId>org.projectlombok</groupId>
 *             <artifactId>lombok</artifactId>
 *             <version>1.18.22</version>
 *         </dependency>
 *
 *         <dependency>
 *             <groupId>cn.hutool</groupId>
 *             <artifactId>hutool-all</artifactId>
 *             <version>5.7.15</version>
 *         </dependency>
 *
 *
 *
 *
 *
 *
 *
 */


public class Test2 {

    private static String name;

    //表头行
    static AtomicInteger headNo = new AtomicInteger(0);
    static List<Object> headLine;

    static List<PersonalTeam> personalTeams = new ArrayList<>();

    static Integer personYear;


    static Integer teamYear;



    /*
    * 反射过滤
    * */
    private static List<PersonalBean> basicFilter(List<PersonalBean> personalBeans) throws IllegalAccessException {
        Iterator<PersonalBean> iterator = personalBeans.iterator();

        while (iterator.hasNext()) {
            PersonalBean personalBean = iterator.next();
            Field[] declaredFields = PersonalBean.class.getDeclaredFields();
            BigDecimal bigDecimal = new BigDecimal(0);
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
                if (declaredField.getName().startsWith("t")) {
                    BigDecimal bigDecimal1 = (BigDecimal) declaredField.get(personalBean);
                    if (ObjectUtil.isNull(bigDecimal1)) {
                        bigDecimal1 = new BigDecimal(0);
                    }
                    bigDecimal = bigDecimal.add(bigDecimal1);
                }

            }

            if (bigDecimal.compareTo(new BigDecimal(0)) == 0) {
                iterator.remove();
            }


        }


        return personalBeans;
    }


    public static void main(String[] args) throws IllegalAccessException, InterruptedException {
        //初始化数据
        System.out.println("------------------------------");
        System.out.println("  ---文档一定要取消密码!!!  ");
        System.out.println("  ---文档一定要取消密码!!!  ");
        System.out.println("  ---文档一定要取消密码!!!  ");
        System.out.println("  ---文档一定要取消密码!!!  ");
        System.out.println("------------------------------");

        TimeUnit.SECONDS.sleep(2);

        Scanner scanner = new Scanner(System.in);
        System.out.println("需要过滤的姓名:");
        name = scanner.nextLine();

        System.out.println("个人工时表位置:");
        String personTime = scanner.nextLine();
        personTime = personTime.replaceAll("'","");
        if (personTime.contains("2022")) {
            personYear = 2022;
        } else if (personTime.contains("2021")) {
            personYear = 2021;
        } else {
            throw new RuntimeException("解析年份失败,请确保文件命中含有年份");
        }


        List<PersonalBean> personalBeans = personReader(personTime);

        personalBeans = basicFilter(personalBeans);

        System.out.println("团队映射表位置:");
        String teamTime = scanner.nextLine();
        teamTime = teamTime.replaceAll("'","");
        if (teamTime.contains("2022")) {
            teamYear = 2022;
        } else if (teamTime.contains("2021")) {
            teamYear = 2021;
        } else {
            throw new RuntimeException("解析年份失败,请确保文件命中含有年份");
        }

        if (!teamYear.equals(personYear)){
            throw new RuntimeException("双文件年份不匹配或名称命名不规范,请检查");
        }

        List<PersonalTeam> personalTeams1;
        List<PersonalTeam> collect;
        for (int i = 0; i < personalBeans.size(); i++) {
            //取出个人工时表的当前数据
            PersonalBean personalBean = personalBeans.get(i);
            ExcelReader reader = ExcelUtil.getReader(teamTime.trim());
             personalTeams1 = teamReader(reader, personalBean);
             collect = personalTeams1
                    .stream()
                    .filter(personalTeam -> ( StrUtil.isNotBlank(personalTeam.getName()) ) && personalTeam.getName().equals(name))
                    .collect(Collectors.toList());

            //封装了当前sheet页里分类数据
            HashMap<String, BigDecimal> sheetTeamMap = collectData(collect,personalBean);

            //比对当前sheet页每一项工时是否一致
            String sheetName = reader.getSheet().getSheetName();

            try {
                compareManHour(sheetTeamMap, personalBean);
            } catch (Exception e) {
                System.out.println("是否继续校验:(y/n)");
                String s = scanner.nextLine();
                if (!"y".equalsIgnoreCase(s)) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println("sheet:"+sheetName+"对比完成");
        }


        //log.info("data:{}", personalTeams);


    }


    private static void compareManHour(HashMap<String, BigDecimal> sheetTeamMap, PersonalBean personalBean) throws NoSuchFieldException, IllegalAccessException {
        Set<String> keySets = sheetTeamMap.keySet();
        for (String key : keySets) {
            //获取当前sheet中的合并值
            BigDecimal sheetTeamBigDecimal = sheetTeamMap.get(key);
            if (ObjectUtil.isNull(sheetTeamBigDecimal)) {
                sheetTeamBigDecimal = new BigDecimal(0);
            }

            //获取映射
            String s = PersonalBean.nameMap.get(key);
            //空值忽略
            if (StrUtil.isBlank(s)) {
                return;
            }
            Field declaredField = PersonalBean.class.getDeclaredField(s);
            declaredField.setAccessible(true);
            BigDecimal target = (BigDecimal) declaredField.get(personalBean);
            if (ObjectUtil.isNull(target)) {
                target = new BigDecimal(0);
            }

            if (sheetTeamBigDecimal.compareTo(target) != 0) {
                //有出入

                System.out.println("------------------------------");
                System.out.println("---------发现异常-------------");
                System.out.println("错误时间为:" + personalBean.getSTime() + "     错误一级分类:" + key);
                System.out.println("团队周报时间为:"+sheetTeamBigDecimal+",个人工时时间为:"+target);
                System.out.println("------------------------------");
                System.out.println("------------------------------");
                System.out.println("------------------------------");
                throw new RuntimeException("错误时间为:" + personalBean.getSTime() + "错误一级分类为--->" + key);
            }


        }


    }

    private static HashMap<String, BigDecimal> collectData(List<PersonalTeam> collect, PersonalBean personalBean) {
        HashMap<String, BigDecimal> ha = new HashMap<>();
        for (PersonalTeam personalTeam : collect) {
            String firstLevel = personalTeam.getFirstLevel();
            BigDecimal manHour = personalTeam.getManHour();
            if (ObjectUtil.isNull(manHour)){
                manHour = new BigDecimal(0);
            }
            if (StrUtil.isBlank(firstLevel) && manHour.compareTo(new BigDecimal(0))>0){
                System.out.println("存在大类空行--->补充空行,位置在:"+personalBean.getSTime());
                throw new RuntimeException();
            }
            BigDecimal bigDecimal = ha.get(firstLevel);
            if (ObjectUtil.isNull(bigDecimal)) {
                bigDecimal = new BigDecimal(0);
            }
            bigDecimal = bigDecimal.add(ObjectUtil.isNull(personalTeam.getManHour()) ? new BigDecimal(0) : personalTeam.getManHour());

            ha.put(firstLevel, bigDecimal);

        }

        return ha;
    }


    static List<PersonalBean> personReader(String path) {

        ExcelReader reader = ExcelUtil.getReader(path.trim());

        aliasPersonalAssembly(reader);

        //获取所有对象
        List<PersonalBean> personalBeans = reader.readAll(PersonalBean.class);

        return personalBeans;


      /*  Excel07SaxReader reader1 = new Excel07SaxReader(null);
        reader1.read("d:/text.xlsx", 0);*/


    }


    static List<PersonalTeam> teamReader(ExcelReader reader, PersonalBean personalBean) {

        String sTime = personalBean.getSTime();

        String[] split = sTime.split(":");
        String data = split[1];
        String[] strArray = data.split("-");

        String sheetName;

        if (strArray.length > 1) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < strArray.length; i++) {
                if (i == strArray.length - 1) {
                    s.append("-");
                }
                s.append(personYear + " ");
                String replace = strArray[i].replace("/", " ");
                s.append(replace);
            }
            sheetName = s.toString();
        } else {
            sheetName = personYear + " " + strArray[0].replace("/", " ");

        }


        reader.setSheet(sheetName);
        aliasTeamAssembly(reader);

        List<PersonalTeam> personalTeams1 = reader.readAll(PersonalTeam.class);
      /*  Excel07SaxReader reader1 = new Excel07SaxReader(null);
        reader1.read("d:/text.xlsx", 0);*/

        if (CollUtil.isEmpty(personalTeams1)){
            System.out.println(sheetName+" 解析失败,请检查sheet页命名是否正确");
            System.out.println("任意键继续检查下个sheet页");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();


        }

        return personalTeams1;
    }


    //别名装配
    static void aliasPersonalAssembly(ExcelReader ExcelReader) {
       /* ExcelReader.addHeaderAlias("姓名", "name");
        ExcelReader.addHeaderAlias("周", "week");
        ExcelReader.addHeaderAlias("时间", "time");
        ExcelReader.addHeaderAlias("小鱼智能云视频会议系统V3.5", "t1");
        ExcelReader.addHeaderAlias("小鱼智能云视频会议系统V3.6", "t2");
        ExcelReader.addHeaderAlias("小鱼智能云视频会议系统V3.7", "t3");
        ExcelReader.addHeaderAlias("小鱼智能云视频会议系统V3.8", "t4");
        ExcelReader.addHeaderAlias("小鱼智能分区云会议系统", "t5");
        ExcelReader.addHeaderAlias("小鱼分区云会议系统第二期", "t6");
        ExcelReader.addHeaderAlias("小鱼私有云会议系统第五期", "t7");
        ExcelReader.addHeaderAlias("小鱼风铃视频会议系统", "t8");
        ExcelReader.addHeaderAlias("基础支撑平台第二期", "t9");
        ExcelReader.addHeaderAlias("自适应音视频弱网保护算法研究", "t10");
        ExcelReader.addHeaderAlias("实时会议系统中智能技术应用研究", "t11");
        ExcelReader.addHeaderAlias("弹性分发网络技术预研", "t12");
        ExcelReader.addHeaderAlias("零信任安全云架构技术预研", "t13");
        ExcelReader.addHeaderAlias("超感知音视频技术预研", "t14");
        ExcelReader.addHeaderAlias("智能视频会议终端升级第五期", "t15");
        ExcelReader.addHeaderAlias("桌面触控视频会议终端四代", "t16");
        ExcelReader.addHeaderAlias("分体式视频会议终端三代", "t17");
        ExcelReader.addHeaderAlias("分体式视频会议终端四代", "t18");
        ExcelReader.addHeaderAlias("沉浸式视频会议系统二代", "t19");
        ExcelReader.addHeaderAlias("智能会议平板一代", "t20");
        ExcelReader.addHeaderAlias("一体式视频会议终端二代", "t21");
        ExcelReader.addHeaderAlias("浩海系列媒体服务器一代", "t22");
        ExcelReader.addHeaderAlias("硬件平台和基础技术预研第四期", "t23");
        ExcelReader.addHeaderAlias("卫士通信息产业股份有限公司", "t24");
        ExcelReader.addHeaderAlias("卫士通-信息中心（密会）", "t25");
        ExcelReader.addHeaderAlias("广州市公安局黄埔区分局", "t26");
        ExcelReader.addHeaderAlias("水利部信息中心", "t27");
        ExcelReader.addHeaderAlias("山东省大数据局“山东通”平台整合提升服务项目", "t28");
        ExcelReader.addHeaderAlias("建信金融云视讯平台", "t29");
        ExcelReader.addHeaderAlias("阳光保险集团定制化服务项目", "t30");
        ExcelReader.addHeaderAlias("广东省卫生健康委员会", "t31");
        ExcelReader.addHeaderAlias("生态环境部互联网云视频管理后台", "t32");
        ExcelReader.addHeaderAlias("兴业消费金融股份公司", "t33");
        ExcelReader.addHeaderAlias("中海石油财务有限责任公司", "t34");
        ExcelReader.addHeaderAlias("中国五矿集团有限公司", "t35");
        ExcelReader.addHeaderAlias("中国光大银行股份有限公司", "t36");
        ExcelReader.addHeaderAlias("CRM", "t37");
        ExcelReader.addHeaderAlias("品牌", "t38");
        ExcelReader.addHeaderAlias("运营", "t39");
        ExcelReader.addHeaderAlias("总计", "t40");*/

        Set<String> keySet = PersonalBean.nameMap.keySet();
        for (String s : keySet) {
            ExcelReader.addHeaderAlias(s, PersonalBean.nameMap.get(s));
        }
    }

    static void aliasTeamAssembly(ExcelReader ExcelReader) {
        ExcelReader.addHeaderAlias("姓名", "name");
        ExcelReader.addHeaderAlias("一级项目", "firstLevel");
        ExcelReader.addHeaderAlias("工时", "manHour");
    }

    /**
     * 行数据处理
     */
    static class MyRowHandler implements RowHandler {
        @Override
        public void handle(int sheetIndex, long rowIndex, List<Object> rowList) {
            if (rowIndex < headNo.get()) {
                return;
            } else if (rowIndex == headNo.get()) {
                headLine = rowList;
            } else {
                //精准匹配
                if (ObjectUtil.isNotEmpty(rowList.get(0)) && rowList.get(0).equals(name)) {
                    //封装为对象
                    PersonalTeam personalTeam = PersonalTeam
                            .builder()
                            .name((String) rowList.get(0))
                            .firstLevel(ObjectUtil.hasNull(rowList.get(2)) ? "" : (String) rowList.get(2))
                            .manHour(NumberUtil.round(ObjectUtil.hasNull(rowList.get(5)) ? 0 : ((Double) rowList.get(5)), 2))
                            .build();

                    personalTeams.add(personalTeam);

                }
            }
        }
    }


}


@Data
class PersonalBean {

    public static final HashMap<String, String> nameMap;

    static {
        nameMap = new HashMap<>();
        nameMap.put("姓名", "name");
        nameMap.put("周", "week");
        nameMap.put("时间", "sTime");
        nameMap.put("小鱼智能云视频会议系统V3.5", "t1");
        nameMap.put("小鱼智能云视频会议系统V3.6", "t2");
        nameMap.put("小鱼智能云视频会议系统V3.7", "t3");
        nameMap.put("小鱼智能云视频会议系统V3.8", "t4");
        nameMap.put("小鱼智能分区云会议系统", "t5");
        nameMap.put("小鱼分区云会议系统第二期", "t6");
        nameMap.put("小鱼私有云会议系统第五期", "t7");
        nameMap.put("小鱼风铃视频会议系统", "t8");
        nameMap.put("基础支撑平台第二期", "t9");
        nameMap.put("自适应音视频弱网保护算法研究", "t10");
        nameMap.put("实时会议系统中智能技术应用研究", "t11");
        nameMap.put("弹性分发网络技术预研", "t12");
        nameMap.put("零信任安全云架构技术预研", "t13");
        nameMap.put("超感知音视频技术预研", "t14");
        nameMap.put("智能视频会议终端升级第五期", "t15");
        nameMap.put("桌面触控视频会议终端四代", "t16");
        nameMap.put("分体式视频会议终端三代", "t17");
        nameMap.put("分体式视频会议终端四代", "t18");
        nameMap.put("沉浸式视频会议系统二代", "t19");
        nameMap.put("智能会议平板一代", "t20");
        nameMap.put("一体式视频会议终端二代", "t21");
        nameMap.put("浩海系列媒体服务器一代", "t22");
        nameMap.put("硬件平台和基础技术预研第四期", "t23");
        nameMap.put("卫士通信息产业股份有限公司", "t24");
        nameMap.put("卫士通-信息中心（密会）", "t25");
        nameMap.put("广州市公安局黄埔区分局", "t26");
        nameMap.put("水利部信息中心", "t27");
        nameMap.put("山东省大数据局“山东通”平台整合提升服务项目", "t28");
        nameMap.put("建信金融云视讯平台", "t29");
        nameMap.put("阳光保险集团定制化服务项目", "t30");
        nameMap.put("广东省卫生健康委员会", "t31");
        nameMap.put("生态环境部互联网云视频管理后台", "t32");
        nameMap.put("兴业消费金融股份公司", "t33");
        nameMap.put("中海石油财务有限责任公司", "t34");
        nameMap.put("中国五矿集团有限公司", "t35");
        nameMap.put("中国光大银行股份有限公司", "t36");
        nameMap.put("CRM", "t37");
        nameMap.put("品牌", "t38");
        nameMap.put("运营", "t39");
        nameMap.put("总计", "t40");
        //2021
        nameMap.put("小鱼智能云视频会议系统V3.1", "t41");
        nameMap.put("小鱼智能云视频会议系统V3.2", "t42");
        nameMap.put("小鱼智能云视频会议系统V3.3", "t43");
        nameMap.put("小鱼智能云视频会议系统V3.4", "t44");
        nameMap.put("小鱼分区云会议系统", "t45");
        nameMap.put("小鱼私有云会议系统第四期", "t46");
        nameMap.put("基础支撑平台第一期", "t47");
        nameMap.put("画质评价与增强技术预研", "t48");
        nameMap.put("基于TCP加速的低延迟可靠消息通道技术研究", "t49");
        nameMap.put("智能视频会议终端升级第四期", "t50");
        nameMap.put("沉浸式视频会议系统一代", "t51");
        nameMap.put("终端平台和基础技术预研第三期", "t52");
        nameMap.put("民航局", "t53");
        nameMap.put("新疆兵团公安局移动警务平台项目", "t54");
        nameMap.put("中国人寿", "t55");

    }

    //姓名
    private String name;
    //时间
    private String sTime;

    private Integer week;

    private BigDecimal t1;
    private BigDecimal t2;
    private BigDecimal t3;
    private BigDecimal t4;
    private BigDecimal t5;
    private BigDecimal t6;
    private BigDecimal t7;
    private BigDecimal t8;
    private BigDecimal t9;
    private BigDecimal t10;
    private BigDecimal t11;
    private BigDecimal t12;
    private BigDecimal t13;
    private BigDecimal t14;
    private BigDecimal t15;
    private BigDecimal t16;
    private BigDecimal t17;
    private BigDecimal t18;
    private BigDecimal t19;
    private BigDecimal t20;
    private BigDecimal t21;
    private BigDecimal t22;
    private BigDecimal t23;
    private BigDecimal t24;
    private BigDecimal t25;
    private BigDecimal t26;
    private BigDecimal t27;
    private BigDecimal t28;
    private BigDecimal t29;
    private BigDecimal t30;
    private BigDecimal t31;
    private BigDecimal t32;
    private BigDecimal t33;
    private BigDecimal t34;
    private BigDecimal t35;
    private BigDecimal t36;
    private BigDecimal t37;
    private BigDecimal t38;
    private BigDecimal t39;
    private BigDecimal t40;
    private BigDecimal t41;
    private BigDecimal t42;
    private BigDecimal t43;
    private BigDecimal t44;
    private BigDecimal t45;
    private BigDecimal t46;
    private BigDecimal t47;
    private BigDecimal t48;
    private BigDecimal t49;
    private BigDecimal t50;
    private BigDecimal t51;
    private BigDecimal t52;
    private BigDecimal t53;
    private BigDecimal t54;
    private BigDecimal t55;


}


@Data
@Builder
class PersonalTeam {

    private String name;

    private String firstLevel;

    private BigDecimal manHour;

}




