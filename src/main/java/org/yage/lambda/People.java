package org.yage.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: Yage
 * @create: 2022-12-07 09:27
 */
@Data
@AllArgsConstructor
public class People {
    private String name;
    private Long value;

    public static Integer convert(String value) {
        return Integer.parseInt(value);
    }
}
