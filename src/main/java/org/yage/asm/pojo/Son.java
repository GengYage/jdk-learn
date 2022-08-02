package org.yage.asm.pojo;

/**
 * @author: Yage
 * @create: 2022-08-02 14:49
 */
public class Son extends Father{
    public String str = "son";

    @Override
    protected void say() {
        System.out.println("I am son.");
    }

    public void call() {
        Father father = new Son();
        System.out.println(father.str);
        father.say();
    }
}
