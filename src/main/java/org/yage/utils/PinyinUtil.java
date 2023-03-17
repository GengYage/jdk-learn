package org.yage.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.HashMap;
import java.util.Map;

public class PinyinUtil {
    private static final Map<Character, String> surnames = new HashMap(35);
    private static final Map<Character, String> strangeWords = new HashMap(525);

    public PinyinUtil() {
    }

    public static String getPinYin(String src) {
        if (null != src && !src.isEmpty()) {
            char[] t1 = src.toCharArray();
            String[] t2 = new String[t1.length];
            HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
            t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
            t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
            t3.setVCharType(HanyuPinyinVCharType.WITH_V);
            StringBuffer t4 = new StringBuffer();
            int t0 = t1.length;
            int hyCount = 0;
            StringBuffer szm = new StringBuffer();

            try {
                for(int i = 0; i < t0; ++i) {
                    if (!Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+")) {
                        t4.append(Character.toString(t1[i]));
                    } else {
                        String sw;
                        if (hyCount == 0 && surnames.containsKey(t1[i])) {
                            sw = (String)surnames.get(t1[i]);
                            t4.append(sw);
                            szm.append(sw.substring(0, 1));
                        } else {
                            t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
                            if (null != t2 && t2.length >= 1) {
                                t4.append(t2[0]);
                                szm.append(t2[0].substring(0, 1));
                            } else if (strangeWords.containsKey(t1[i])) {
                                sw = (String)strangeWords.get(t1[i]);
                                t4.append(sw);
                                szm.append(sw.substring(0, 1));
                            } else {
                                t4.append('#');
                                szm.append('#');
                            }
                        }

                        ++hyCount;
                    }
                }
            } catch (BadHanyuPinyinOutputFormatCombination var10) {
                return src;
            }

            return t4.append(";").append(szm).toString();
        } else {
            return null;
        }
    }

    public static String getPinYinFromHz(String src) {
        if (null != src && !src.isEmpty()) {
            char[] t1 = src.toCharArray();
            String[] t2 = new String[t1.length];
            HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
            t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
            t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
            t3.setVCharType(HanyuPinyinVCharType.WITH_V);
            StringBuffer t4 = new StringBuffer();
            int t0 = t1.length;
            int hyCount = 0;

            try {
                for(int i = 0; i < t0; ++i) {
                    if (!Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+")) {
                        t4.append(Character.toString(t1[i]));
                    } else {
                        String sw;
                        if (hyCount == 0 && surnames.containsKey(t1[i])) {
                            sw = (String)surnames.get(t1[i]);
                            t4.append(sw);
                        } else {
                            t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
                            if (null != t2 && t2.length >= 1) {
                                t4.append(t2[0]);
                            } else if (strangeWords.containsKey(t1[i])) {
                                sw = (String)strangeWords.get(t1[i]);
                                t4.append(sw);
                            } else {
                                t4.append('#');
                            }
                        }

                        ++hyCount;
                    }
                }
            } catch (BadHanyuPinyinOutputFormatCombination var9) {
                return src;
            }

            return t4.toString();
        } else {
            return null;
        }
    }

    public static boolean isChinese(char c) {
        return c >= 19968 && c <= '龥';
    }

    public static boolean isChinese(String str) {
        if (str == null) {
            return false;
        } else {
            char[] var1 = str.toCharArray();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                char c = var1[var3];
                if (isChinese(c)) {
                    return true;
                }
            }

            return false;
        }
    }

    static {
        surnames.put('乐', "yue");
        surnames.put('乘', "sheng");
        surnames.put('乜', "nie");
        surnames.put('仇', "qiu");
        surnames.put('会', "gui");
        surnames.put('便', "pian");
        surnames.put('区', "ou");
        surnames.put('单', "shan");
        surnames.put('参', "shen");
        surnames.put('句', "gou");
        surnames.put('召', "shao");
        surnames.put('员', "yun");
        surnames.put('宓', "fu");
        surnames.put('弗', "fei");
        surnames.put('折', "she");
        surnames.put('曾', "zeng");
        surnames.put('朴', "piao");
        surnames.put('查', "zha");
        surnames.put('洗', "xian");
        surnames.put('盖', "ge");
        surnames.put('祭', "zhai");
        surnames.put('种', "chong");
        surnames.put('秘', "bi");
        surnames.put('繁', "po");
        surnames.put('缪', "miao");
        surnames.put('能', "nai");
        surnames.put('蕃', "pi");
        surnames.put('覃', "qin");
        surnames.put('解', "xie");
        surnames.put('谌', "shan");
        surnames.put('适', "kuo");
        surnames.put('都', "du");
        surnames.put('阿', "e");
        surnames.put('难', "ning");
        surnames.put('黑', "he");
        strangeWords.put('丆', "han");
        strangeWords.put('丷', "ba");
        strangeWords.put('乄', "wu");
        strangeWords.put('乊', "yi");
        strangeWords.put('乛', "yi");
        strangeWords.put('乤', "xia");
        strangeWords.put('乥', "hol");
        strangeWords.put('乧', "dou");
        strangeWords.put('乬', "ju");
        strangeWords.put('乮', "mao");
        strangeWords.put('乯', "hu");
        strangeWords.put('乲', "ca");
        strangeWords.put('乺', "suo");
        strangeWords.put('乻', "yu");
        strangeWords.put('乼', "zhu");
        strangeWords.put('乽', "zhe");
        strangeWords.put('亇', "ge");
        strangeWords.put('亪', "ye");
        strangeWords.put('亽', "ji");
        strangeWords.put('仒', "bing");
        strangeWords.put('佦', "you");
        strangeWords.put('佨', "bao");
        strangeWords.put('侤', "ta");
        strangeWords.put('俧', "zhi");
        strangeWords.put('倿', "ning");
        strangeWords.put('傦', "gu");
        strangeWords.put('儏', "can");
        strangeWords.put('兯', "han");
        strangeWords.put('兺', "bun");
        strangeWords.put('冧', "lin");
        strangeWords.put('凧', "zheng");
        strangeWords.put('凩', "mu");
        strangeWords.put('凪', "zhi");
        strangeWords.put('匁', "mo");
        strangeWords.put('匂', "xiong");
        strangeWords.put('匇', "yi");
        strangeWords.put('厁', "san");
        strangeWords.put('厑', "ya");
        strangeWords.put('厼', "ke");
        strangeWords.put('叾', "du");
        strangeWords.put('呚', "hua");
        strangeWords.put('哖', "nian");
        strangeWords.put('哘', "xing");
        strangeWords.put('哛', "ppun");
        strangeWords.put('唜', "mas");
        strangeWords.put('唟', "keos");
        strangeWords.put('唥', "leng");
        strangeWords.put('啹', "ju");
        strangeWords.put('喸', "po");
        strangeWords.put('嗭', "ci");
        strangeWords.put('嗴', "qiang");
        strangeWords.put('嘊', "ai");
        strangeWords.put('嘥', "sai");
        strangeWords.put('噺', "xin");
        strangeWords.put('嚑', "xun");
        strangeWords.put('嚒', "me");
        strangeWords.put('嚡', "xie");
        strangeWords.put('囎', "zeng");
        strangeWords.put('囕', "ram");
        strangeWords.put('囖', "luo");
        strangeWords.put('圦', "kuai");
        strangeWords.put('圷', "xia");
        strangeWords.put('圸', "shan");
        strangeWords.put('垈', "dai");
        strangeWords.put('垊', "min");
        strangeWords.put('垪', "bing");
        strangeWords.put('垰', "ka");
        strangeWords.put('垳', "hang");
        strangeWords.put('埖', "hua");
        strangeWords.put('堏', "fang");
        strangeWords.put('堒', "kun");
        strangeWords.put('塀', "ping");
        strangeWords.put('塰', "hai");
        strangeWords.put('墛', "wei");
        strangeWords.put('墹', "jian");
        strangeWords.put('壗', "jin");
        strangeWords.put('壪', "wan");
        strangeWords.put('壭', "san");
        strangeWords.put('夈', "zhai");
        strangeWords.put('夑', "xie");
        strangeWords.put('夞', "yi");
        strangeWords.put('夻', "hua");
        strangeWords.put('奍', "quan");
        strangeWords.put('娐', "fu");
        strangeWords.put('婔', "fei");
        strangeWords.put('婮', "ju");
        strangeWords.put('婲', "hua");
        strangeWords.put('媈', "hui");
        strangeWords.put('媘', "jie");
        strangeWords.put('媫', "jie");
        strangeWords.put('嫲', "ma");
        strangeWords.put('嬄', "yi");
        strangeWords.put('嬜', "xin");
        strangeWords.put('嬫', "rong");
        strangeWords.put('嬳', "yue");
        strangeWords.put('嬶', "ka");
        strangeWords.put('孧', "you");
        strangeWords.put('尡', "hun");
        strangeWords.put('屗', "uu");
        strangeWords.put('屶', "hui");
        strangeWords.put('屷', "hui");
        strangeWords.put('岃', "ren");
        strangeWords.put('岼', "ping");
        strangeWords.put('岾', "zhan");
        strangeWords.put('峅', "bian");
        strangeWords.put('峠', "qia");
        strangeWords.put('崊', "lin");
        strangeWords.put('嵵', "shi");
        strangeWords.put('嵶', "ruo");
        strangeWords.put('嵻', "kang");
        strangeWords.put('嶶', "wei");
        strangeWords.put('嶿', "ru");
        strangeWords.put('巪', "ju");
        strangeWords.put('巬', "gu");
        strangeWords.put('巭', "gu");
        strangeWords.put('巼', "pa");
        strangeWords.put('幉', "die");
        strangeWords.put('幥', "zhang");
        strangeWords.put('庒', "zhuang");
        strangeWords.put('廤', "ku");
        strangeWords.put('廭', "ji");
        strangeWords.put('彁', "ge");
        strangeWords.put('彅', "jian");
        strangeWords.put('徔', "cong");
        strangeWords.put('徚', "dong");
        strangeWords.put('怺', "yong");
        strangeWords.put('怽', "mi");
        strangeWords.put('怾', "gi");
        strangeWords.put('恷', "qiu");
        strangeWords.put('愥', "ying");
        strangeWords.put('愰', "huang");
        strangeWords.put('慐', "gong");
        strangeWords.put('懳', "hui");
        strangeWords.put('扖', "ru");
        strangeWords.put('抣', "yun");
        strangeWords.put('挘', "lie");
        strangeWords.put('挧', "yu");
        strangeWords.put('捤', "wei");
        strangeWords.put('掵', "ming");
        strangeWords.put('掶', "jie");
        strangeWords.put('掹', "meng");
        strangeWords.put('揻', "wei");
        strangeWords.put('揼', "beng");
        strangeWords.put('摗', "sou");
        strangeWords.put('撶', "hua");
        strangeWords.put('擜', "e");
        strangeWords.put('擝', "meng");
        strangeWords.put('攚', "weng");
        strangeWords.put('敾', "shan");
        strangeWords.put('旀', "mie");
        strangeWords.put('旕', "eos");
        strangeWords.put('暃', "fei");
        strangeWords.put('曕', "yan");
        strangeWords.put('曢', "liao");
        strangeWords.put('朑', "ti");
        strangeWords.put('朥', "lao");
        strangeWords.put('朰', "te");
        strangeWords.put('杁', "ru");
        strangeWords.put('杢', "jie");
        strangeWords.put('杣', "mian");
        strangeWords.put('杤', "wan");
        strangeWords.put('枠', "hua");
        strangeWords.put('枤', "di");
        strangeWords.put('柨', "bu");
        strangeWords.put('栃', "li");
        strangeWords.put('栆', "zao");
        strangeWords.put('栍', "sa");
        strangeWords.put('栶', "yin");
        strangeWords.put('桛', "ka");
        strangeWords.put('桝', "jie");
        strangeWords.put('桞', "liu");
        strangeWords.put('梺', "xia");
        strangeWords.put('梻', "fo");
        strangeWords.put('椚', "men");
        strangeWords.put('椛', "hua");
        strangeWords.put('椡', "dao");
        strangeWords.put('椣', "dian");
        strangeWords.put('椦', "quan");
        strangeWords.put('椧', "mi");
        strangeWords.put('椨', "fu");
        strangeWords.put('椩', "geng");
        strangeWords.put('椬', "yi");
        strangeWords.put('楾', "quan");
        strangeWords.put('榁', "shi");
        strangeWords.put('榊', "shen");
        strangeWords.put('榋', "chu");
        strangeWords.put('榌', "bi");
        strangeWords.put('槝', "dao");
        strangeWords.put('槡', "sang");
        strangeWords.put('樭', "ji");
        strangeWords.put('樮', "yan");
        strangeWords.put('樰', "xue");
        strangeWords.put('橲', "xi");
        strangeWords.put('橳', "sheng");
        strangeWords.put('橴', "zi");
        strangeWords.put('橵', "zan");
        strangeWords.put('橸', "jing");
        strangeWords.put('橺', "xian");
        strangeWords.put('橻', "cu");
        strangeWords.put('檲', "tuan");
        strangeWords.put('櫊', "ge");
        strangeWords.put('櫔', "li");
        strangeWords.put('櫤', "jiang");
        strangeWords.put('櫦', "qing");
        strangeWords.put('櫵', "qiao");
        strangeWords.put('櫷', "gui");
        strangeWords.put('欌', "cang");
        strangeWords.put('欍', "jiu");
        strangeWords.put('欕', "yan");
        strangeWords.put('欟', "guan");
        strangeWords.put('歄', "gua");
        strangeWords.put('歚', "shan");
        strangeWords.put('殝', "zhen");
        strangeWords.put('毜', "hao");
        strangeWords.put('毝', "cai");
        strangeWords.put('毟', "lie");
        strangeWords.put('毮', "sha");
        strangeWords.put('毶', "san");
        strangeWords.put('氞', "nei");
        strangeWords.put('汢', "tu");
        strangeWords.put('汣', "jiu");
        strangeWords.put('汼', "niu");
        strangeWords.put('洜', "luo");
        strangeWords.put('浌', "fa");
        strangeWords.put('涥', "heng");
        strangeWords.put('渏', "yi");
        strangeWords.put('湪', "tuan");
        strangeWords.put('湭', "qiu");
        strangeWords.put('溄', "feng");
        strangeWords.put('溊', "bo");
        strangeWords.put('溋', "ying");
        strangeWords.put('潈', "cong");
        strangeWords.put('潉', "kun");
        strangeWords.put('潱', "ye");
        strangeWords.put('澝', "ning");
        strangeWords.put('濸', "cang");
        strangeWords.put('瀭', "shu");
        strangeWords.put('瀮', "lian");
        strangeWords.put('灐', "ying");
        strangeWords.put('灜', "ying");
        strangeWords.put('灳', "hui");
        strangeWords.put('炿', "zhou");
        strangeWords.put('烥', "ju");
        strangeWords.put('烪', "zhen");
        strangeWords.put('烮', "lie");
        strangeWords.put('焁', "xi");
        strangeWords.put('焑', "yan");
        strangeWords.put('焒', "lv");
        strangeWords.put('焹', "gang");
        strangeWords.put('焽', "xiong");
        strangeWords.put('焾', "nian");
        strangeWords.put('焿', "geng");
        strangeWords.put('煀', "qu");
        strangeWords.put('煯', "jie");
        strangeWords.put('煶', "shi");
        strangeWords.put('煷', "huo");
        strangeWords.put('熍', "qiong");
        strangeWords.put('熕', "gong");
        strangeWords.put('熖', "yan");
        strangeWords.put('熴', "kun");
        strangeWords.put('燝', "zhu");
        strangeWords.put('燞', "jiao");
        strangeWords.put('燵', "da");
        strangeWords.put('燶', "nong");
        strangeWords.put('爎', "liao");
        strangeWords.put('爘', "can");
        strangeWords.put('爠', "qu");
        strangeWords.put('爳', "han");
        strangeWords.put('牗', "you");
        strangeWords.put('猠', "ceon");
        strangeWords.put('獇', "qiang");
        strangeWords.put('獤', "dun");
        strangeWords.put('珯', "lao");
        strangeWords.put('琒', "feng");
        strangeWords.put('琼', "qiong");
        strangeWords.put('瑡', "shi");
        strangeWords.put('璍', "ye");
        strangeWords.put('璓', "xiu");
        strangeWords.put('璤', "hui");
        strangeWords.put('璴', "chu");
        strangeWords.put('瓧', "shiwa");
        strangeWords.put('瓰', "fenwa");
        strangeWords.put('瓱', "maowa");
        strangeWords.put('瓲', "tunwa");
        strangeWords.put('瓸', "baiwa");
        strangeWords.put('瓼', "liwa");
        strangeWords.put('甅', "liwa");
        strangeWords.put('甮', "beng");
        strangeWords.put('畓', "duo");
        strangeWords.put('畠', "zai");
        strangeWords.put('畩', "yi");
        strangeWords.put('癦', "meng");
        strangeWords.put('癷', "bo");
        strangeWords.put('睵', "zai");
        strangeWords.put('砛', "jin");
        strangeWords.put('砽', "yong");
        strangeWords.put('硓', "lao");
        strangeWords.put('硘', "qing");
        strangeWords.put('硛', "ji");
        strangeWords.put('硧', "yong");
        strangeWords.put('硳', "ce");
        strangeWords.put('硴', "hua");
        strangeWords.put('硸', "nue");
        strangeWords.put('碵', "tian");
        strangeWords.put('碷', "dun");
        strangeWords.put('磗', "zhuan");
        strangeWords.put('磮', "lun");
        strangeWords.put('礢', "yang");
        strangeWords.put('祍', "ren");
        strangeWords.put('禙', "bei");
        strangeWords.put('禣', "fu");
        strangeWords.put('稤', "lue");
        strangeWords.put('稥', "xiang");
        strangeWords.put('穃', "rong");
        strangeWords.put('穒', "kweok");
        strangeWords.put('穝', "zuo");
        strangeWords.put('穦', "pin");
        strangeWords.put('穯', "se");
        strangeWords.put('窤', "guan");
        strangeWords.put('窧', "zhuo");
        strangeWords.put('窽', "kuan");
        strangeWords.put('笂', "wan");
        strangeWords.put('笹', "ti");
        strangeWords.put('笽', "min");
        strangeWords.put('筽', "o");
        strangeWords.put('箮', "xuan");
        strangeWords.put('篐', "gu");
        strangeWords.put('篒', "yi");
        strangeWords.put('簓', "diao");
        strangeWords.put('簯', "qi");
        strangeWords.put('籂', "shi");
        strangeWords.put('籎', "yi");
        strangeWords.put('籡', "qie");
        strangeWords.put('粂', "zhai");
        strangeWords.put('粐', "hu");
        strangeWords.put('粩', "lao");
        strangeWords.put('粭', "he");
        strangeWords.put('糀', "hua");
        strangeWords.put('糘', "jia");
        strangeWords.put('綜', "zong");
        strangeWords.put('緓', "ying");
        strangeWords.put('緕', "zi");
        strangeWords.put('縅', "wei");
        strangeWords.put('縇', "seon");
        strangeWords.put('繌', "zong");
        strangeWords.put('繧', "wen");
        strangeWords.put('纐', "jiao");
        strangeWords.put('罀', "zhao");
        strangeWords.put('罉', "cheng");
        strangeWords.put('罖', "wang");
        strangeWords.put('翶', "ao");
        strangeWords.put('耂', "lao");
        strangeWords.put('聁', "uu");
        strangeWords.put('聓', "xu");
        strangeWords.put('聢', "ding");
        strangeWords.put('聣', "ni");
        strangeWords.put('聺', "qie");
        strangeWords.put('胿', "gui");
        strangeWords.put('脌', "nin");
        strangeWords.put('脦', "de");
        strangeWords.put('膒', "ou");
        strangeWords.put('舤', "fan");
        strangeWords.put('舿', "kua");
        strangeWords.put('艈', "yu");
        strangeWords.put('艔', "dao");
        strangeWords.put('艝', "xue");
        strangeWords.put('艠', "deng");
        strangeWords.put('苆', "qie");
        strangeWords.put('茐', "cong");
        strangeWords.put('茒', "yuan");
        strangeWords.put('茾', "qian");
        strangeWords.put('荢', "zi");
        strangeWords.put('莻', "neus");
        strangeWords.put('萙', "zhen");
        strangeWords.put('萞', "bi");
        strangeWords.put('萟', "yi");
        strangeWords.put('萡', "bo");
        strangeWords.put('萢', "pao");
        strangeWords.put('蒅', "ran");
        strangeWords.put('蒊', "hua");
        strangeWords.put('蒏', "yong");
        strangeWords.put('蓃', "sou");
        strangeWords.put('蓙', "zuo");
        strangeWords.put('蓜', "pei");
        strangeWords.put('蓞', "dan");
        strangeWords.put('蓤', "ling");
        strangeWords.put('藔', "liao");
        strangeWords.put('藵', "bao");
        strangeWords.put('蘒', "qiu");
        strangeWords.put('蘕', "peng");
        strangeWords.put('蘰', "man");
        strangeWords.put('虄', "sa");
        strangeWords.put('虅', "teng");
        strangeWords.put('虲', "uu");
        strangeWords.put('蛯', "lao");
        strangeWords.put('蝊', "uu");
        strangeWords.put('螦', "sao");
        strangeWords.put('螧', "qi");
        strangeWords.put('螩', "dao");
        strangeWords.put('蟐', "chan");
        strangeWords.put('蟵', "chu");
        strangeWords.put('蠴', "shu");
        strangeWords.put('衐', "qu");
        strangeWords.put('袥', "tuo");
        strangeWords.put('袮', "mi");
        strangeWords.put('袰', "bo");
        strangeWords.put('裃', "ka");
        strangeWords.put('裄', "hang");
        strangeWords.put('裇', "xu");
        strangeWords.put('褄', "qi");
        strangeWords.put('褜', "pao");
        strangeWords.put('褝', "dan");
        strangeWords.put('襅', "bi");
        strangeWords.put('襨', "e");
        strangeWords.put('襷', "ju");
        strangeWords.put('襽', "lan");
        strangeWords.put('覄', "fu");
        strangeWords.put('覅', "fiao");
        strangeWords.put('誮', "hua");
        strangeWords.put('謃', "xing");
        strangeWords.put('謉', "kui");
        strangeWords.put('贌', "pu");
        strangeWords.put('贘', "shang");
        strangeWords.put('趰', "er");
        strangeWords.put('踎', "mou");
        strangeWords.put('躮', "fen");
        strangeWords.put('躵', "ren");
        strangeWords.put('躻', "kong");
        strangeWords.put('躼', "lao");
        strangeWords.put('躾', "mei");
        strangeWords.put('軅', "yan");
        strangeWords.put('軈', "ying");
        strangeWords.put('轌', "xue");
        strangeWords.put('辪', "xue");
        strangeWords.put('辷', "yi");
        strangeWords.put('辻', "shi");
        strangeWords.put('込', "yu");
        strangeWords.put('迌', "tu");
        strangeWords.put('迚', "da");
        strangeWords.put('迲', "ke");
        strangeWords.put('逧', "gu");
        strangeWords.put('遖', "nan");
        strangeWords.put('遤', "ma");
        strangeWords.put('邜', "xi");
        strangeWords.put('邤', "xin");
        strangeWords.put('郮', "zhou");
        strangeWords.put('酛', "yuan");
        strangeWords.put('酜', "fu");
        strangeWords.put('釻', "qiu");
        strangeWords.put('鈨', "yuan");
        strangeWords.put('鈪', "e");
        strangeWords.put('鈫', "qin");
        strangeWords.put('銯', "si");
        strangeWords.put('鋢', "lue");
        strangeWords.put('鋲', "bing");
        strangeWords.put('鋴', "zhen");
        strangeWords.put('錻', "bu");
        strangeWords.put('錿', "hu");
        strangeWords.put('鍂', "pian");
        strangeWords.put('鍅', "fa");
        strangeWords.put('鎆', "qian");
        strangeWords.put('鎺', "zu");
        strangeWords.put('鎼', "xia");
        strangeWords.put('鎽', "feng");
        strangeWords.put('鎾', "wen");
        strangeWords.put('鏯', "shuang");
        strangeWords.put('鏱', "zhang");
        strangeWords.put('鏲', "qian");
        strangeWords.put('鐢', "fan");
        strangeWords.put('鐣', "cheng");
        strangeWords.put('鑦', "xian");
        strangeWords.put('鑧', "kuan");
        strangeWords.put('閊', "shan");
        strangeWords.put('閚', "zhan");
        strangeWords.put('閪', "se");
        strangeWords.put('闁', "bao");
        strangeWords.put('闎', "quan");
        strangeWords.put('闏', "pai");
        strangeWords.put('闧', "uu");
        strangeWords.put('陹', "sheng");
        strangeWords.put('霗', "ling");
        strangeWords.put('霻', "feng");
        strangeWords.put('靍', "he");
        strangeWords.put('鞰', "wen");
        strangeWords.put('韕', "kuo");
        strangeWords.put('颪', "gua");
        strangeWords.put('飊', "biao");
        strangeWords.put('駯', "zhu");
        strangeWords.put('駲', "zhou");
        strangeWords.put('髸', "gong");
        strangeWords.put('魸', "pian");
        strangeWords.put('魹', "mo");
        strangeWords.put('鮖', "shi");
        strangeWords.put('鮗', "dong");
        strangeWords.put('鮘', "dai");
        strangeWords.put('鮱', "lao");
        strangeWords.put('鮲', "fu");
        strangeWords.put('鮴', "xiu");
        strangeWords.put('鯂', "su");
        strangeWords.put('鯎', "cheng");
        strangeWords.put('鯏', "li");
        strangeWords.put('鯐', "zou");
        strangeWords.put('鯑', "xi");
        strangeWords.put('鯱', "hu");
        strangeWords.put('鯲', "yu");
        strangeWords.put('鯳', "di");
        strangeWords.put('鰘', "shi");
        strangeWords.put('鰚', "xuan");
        strangeWords.put('鰰', "shen");
        strangeWords.put('鱛', "zeng");
        strangeWords.put('鱩', "lei");
        strangeWords.put('鱪', "shu");
        strangeWords.put('鱰', "shu");
        strangeWords.put('鳰', "ru");
        strangeWords.put('鴫', "tian");
        strangeWords.put('鵆', "heng");
        strangeWords.put('鵇', "nian");
        strangeWords.put('鵈', "e");
        strangeWords.put('鵤', "zan");
        strangeWords.put('鵥', "pan");
        strangeWords.put('鶍', "yi");
        strangeWords.put('鶎', "zun");
        strangeWords.put('鶑', "ying");
        strangeWords.put('鶫', "dong");
        strangeWords.put('鶿', "ci");
    }
}