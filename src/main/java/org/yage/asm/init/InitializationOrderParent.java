package org.yage.asm.init;

/**
 * @author: Yage
 * @create: 2022-08-14 19:45
 */
class InitializationOrderParent {
    // 静态变量
    public static String pStaticField = "父类--静态变量";
    // 变量
    public String pField = "父类--变量";

    // 静态初始化块
    static {
        System.out.println(pStaticField);
        System.out.println("父类--静态初始化块");
    }

    // 初始化块
    {
        System.out.println(pField);
        System.out.println("父类--初始化块");
    }

    // 构造器
    public InitializationOrderParent() {
        System.out.println("父类--构造器");
    }
}


