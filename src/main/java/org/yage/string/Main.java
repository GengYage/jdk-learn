package org.yage.string;

/**
 * @author: Yage
 * @create: 2023-01-06 12:49
 */
public class Main {
    public static void main(String[] args) throws Exception {
        //黄金分割数 * 2的32次方 = 2654435769 - 这个是无符号32位整数的黄金分割数对应的那个值
        long c = (long) ((1L << 32) * (Math.sqrt(5) - 1) / 2);
        System.out.println(c);
        //强制转换为带符号为的32位整型，值为-1640531527
        int i = (int) c;
        System.out.println(i);
    }

}
