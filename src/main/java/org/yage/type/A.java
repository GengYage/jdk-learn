package org.yage.type;

import org.apache.commons.lang3.StringUtils;

/**
 * @author: Yage
 * @create: 2023-05-15 19:40
 */
public class A implements Comparable<String> {
    @Override
    public int compareTo(String o) {
        return 0;
    }

    public static void main(String[] args) {
        String str = "123456";
        System.out.println(str.substring(str.length() - 4));
        System.out.println(StringUtils.right(str, 4));
    }
}
