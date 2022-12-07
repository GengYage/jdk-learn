package org.yage.type;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author: Yage
 * @create: 2022-10-08 20:00
 */
public abstract class TypeReference<T> {
    public static void main(String[] args) {
        TypeReference<Map<String, String>> typeReference = new TypeReference<Map<String, String>>(){};

        Type genericSuperclass = typeReference.getClass().getGenericSuperclass();
        System.out.println(genericSuperclass);
        System.out.println(genericSuperclass.getTypeName());
    }
}
