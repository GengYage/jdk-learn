package org.yage.pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author: Yage
 * @create: 2022-12-14 15:01
 */
public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Son son = new Son();
        son.setName("aa");
        son.setAge(1);

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(son));
        System.out.println(son);
    }
}
