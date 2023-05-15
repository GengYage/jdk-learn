package org.yage.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: Yage
 * @create: 2022-12-01 16:59
 */
public class Main {
    public static final List<Integer> LIST = new ArrayList<>();

    static {
        for (int i = 0; i < 1000000; i++) {
            LIST.add(i + 1);
        }
    }


    public static void main(String[] args) {
        @SuppressWarnings("all")
        boolean present = Optional.<A>ofNullable(null).map(A::getName).isPresent();
    }


    static class A {
        String name;
        String value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
