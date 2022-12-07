package org.yage.type;

import org.yage.asm.pojo.Father;
import org.yage.asm.pojo.Son;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * @author: Yage
 * @create: 2022-10-08 19:47
 */
public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<? super Number> integers = new ArrayList<>();
        integers.add(0);
        // integers.add("aaa");

        integers.getClass().getMethod("add", Object.class).invoke(integers, "aaa");

        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }
    }
}
