package org.yage.oom;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yage
 * @create: 2022-08-08 19:04
 */
public class OutOfMemoryTest {

    @Test
    public void heapOOMTest() {
        List<OutOfMemoryTest> list = new ArrayList<>();
        while (true) {
            list.add(new OutOfMemoryTest());
        }
    }
}
