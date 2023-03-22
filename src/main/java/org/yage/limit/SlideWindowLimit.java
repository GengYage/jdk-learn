package org.yage.limit;

/**
 * @author: Yage
 * @create: 2023-03-21 09:53
 */
public class SlideWindowLimit {
    public static void main(String[] args) {
        String a = "aa";

        switch (a) {
            case "aa":
                System.out.println("hello world");
                break;
            case "bb":
                System.out.println("??");
                break;
            default:
                break;
        }

        int c = 2;
        switch (c) {
            case 0:
                System.out.println("0");
                break;
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            default:
                break;
        }
    }
}