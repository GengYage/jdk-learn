package org.yage.lambda;


import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author: Yage
 * @create: 2022-12-07 09:34
 */
public class PeoTest {
    public static void main(String[] args) {
        // 捕获实例方法,在无具体实例的时候
        GetCapt<String, People> getName = People::getName;
        SetCapt<People, String> setName = People::setName;
        // getName.get(); 需要传入一个People实例
        // setName.set();

        // 捕获方法,有具体实例
        People people = new People("hello", 1L);
        Supplier<String> s = people::getName;
        Consumer<String> c = people::setName;
        s.get(); // hello
        c.accept("ok"); // people的name被改为ok
    }
}
