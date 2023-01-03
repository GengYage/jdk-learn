package org.yage.threadlocal;

/**
 * @author: Yage
 * @create: 2023-01-03 19:51
 */
public class Main {

    // 32有符号数黄金分割值
    // ThreadLocal的hash魔数
    private static final int HASH_INCREMENT = 0x61c88647;

    public static void main(String[] args) throws Exception {
        hashCode(2);
        hashCode(4);
        hashCode(8);
        hashCode(16);
        hashCode(32);
    }

    // 完美的散列函数
    private static void hashCode(int capacity) throws Exception {
        int keyIndex;
        for (int i = 0; i < capacity; i++) {
            keyIndex = ((i + 1) * HASH_INCREMENT) & (capacity - 1);
            System.out.print(keyIndex);
            System.out.print(" ");
        }
        System.out.println();
    }
}
