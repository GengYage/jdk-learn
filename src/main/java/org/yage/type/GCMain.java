package org.yage.type;

/**
 * @author: Yage
 * @create: 2023-05-04 19:15
 */
public class GCMain {
    public static void main(String[] args) {
        try {
            Integer[] ints = new Integer[1024 * 1024];
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
