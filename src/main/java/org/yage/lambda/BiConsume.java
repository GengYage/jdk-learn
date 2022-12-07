package org.yage.lambda;

/**
 * @author: Yage
 * @create: 2022-12-06 18:47
 */
@FunctionalInterface
public interface BiConsume<T, U> {
    void accept(T t, U u);
}
