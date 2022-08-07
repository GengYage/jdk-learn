package org.yage.asm.pojo;

/**
 * @author: Yage
 * @create: 2022-08-02 14:49
 */
public class Son extends Father{
    public Son(int a) {
        System.out.println("hello"+a);
    }
    public String str = "son";

    @Override
    protected void say() {
        System.out.println("I am son.");
    }

    public void call() {
        Father father = new Son(1);
        System.out.println(father.str);
        father.say();
        Son son = new Son(1);
        son.hello();
    }
}
