package org.yage.type;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * @author: Yage
 * @create: 2022-11-17 14:28
 */
public class JackSonTest {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> value = objectMapper.readValue("{}", new TypeReference<Map<String, String>>() {
        });

        System.out.println(value);
    }
}
