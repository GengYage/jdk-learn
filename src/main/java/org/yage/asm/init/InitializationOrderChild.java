package org.yage.asm.init;

/**
 * @author: Yage
 * @create: 2022-08-14 19:45
 */
public class InitializationOrderChild extends InitializationOrderParent {
    // 静态变量
    public static String sStaticField = "子类--静态变量";
    // 变量
    public String sField = "子类--变量";

    // 静态初始化块
    static {
        System.out.println(sStaticField);
        System.out.println("子类--静态初始化块");
    }

    // 初始化块
    {
        System.out.println(sField);
        System.out.println("子类--初始化块");
    }

    // 构造器
    public InitializationOrderChild() {
        System.out.println("子类--构造器");
    }

    // 程序入口
    public static void main(String[] args) {
        new InitializationOrderChild();
    }
}
