package org.yage;

import org.yage.utils.PinyinUtil;

public class Main {
    public static void main(String[] args) {
        System.out.println(test());

        String a = "b";
        String v = "X";
        switch (a) {
            case "a":
                v = "A";
            case "b":
                v = "B";
        }
        System.out.println(v);

    }


    public static String test() {
        String a = "aaa";
        try {
            return a;
        } catch (Exception e) {
            a += "b";
        } finally {
            a += "c";
            return a;
        }
    }
}