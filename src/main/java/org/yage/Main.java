package org.yage;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // 31*0+char1 + 31* (13*0 + char1) +char2
        //
        System.out.println("Aa".hashCode());
        System.out.println("BB".hashCode());

        System.out.println("BBAa".hashCode());
        System.out.println("AaBB".hashCode());

        System.out.println("aaBB".hashCode());
        System.out.println("aaAa".hashCode());
    }
}