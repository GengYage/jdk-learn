package org.yage.juc.map;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: Yage
 * @create: 2023-05-09 19:21
 */
public class TraverserTest {
    static final class TableStack {
        int length;
        int index;
        Object[] tab;
        TableStack next;

        @Override
        public String toString() {
            return "TableStack{" +
                    "length=" + length +
                    ", index=" + index +
                    ", tab=" + Arrays.toString(tab) +
                    ", next=" + next +
                    '}';
        }
    }

    static class Traverser {
        Object[] tab;        // current table; updated if resized
        Object next;         // the next entry to use
        TableStack stack, spare; // to save/restore on ForwardingNodes
        int index;              // index of bin to use next
        int baseIndex;          // current index of initial table
        int baseLimit;          // index bound for initial table
        final int baseSize;     // initial table size

        Traverser(Object[] tab, int size, int index, int limit) {
            this.tab = tab;
            this.baseSize = size;
            this.baseIndex = this.index = index;
            this.baseLimit = limit;
            this.next = null;
        }


        private void pushState(Object[] t, int i, int n) {
            TableStack s = spare;  // reuse if possible
            if (s != null)
                spare = s.next;
            else
                s = new TableStack();
            s.tab = t;
            s.length = n;
            s.index = i;
            s.next = stack;
            stack = s;
        }

        private void recoverState(int n) {
            TableStack s;
            int len;
            while ((s = stack) != null && (index += (len = s.length)) >= n) {
                n = len;
                index = s.index;
                tab = s.tab;
                s.tab = null;
                TableStack next = s.next;
                s.next = spare; // save for reuse
                stack = next;
                spare = s;
            }
            if (s == null && (index += baseSize) >= n)
                index = ++baseIndex;
        }

        @Override
        public String toString() {
            return "Traverser{" +
                    "tab=" + Arrays.toString(tab) +
                    ", next=" + next +
                    ", stack=" + stack +
                    ", spare=" + spare +
                    ", index=" + index +
                    ", baseIndex=" + baseIndex +
                    ", baseLimit=" + baseLimit +
                    ", baseSize=" + baseSize +
                    '}';
        }
    }

    public static void main(String[] args) {
        Object[] oldTab = new Object[4];
        Traverser traverser = new Traverser(oldTab, oldTab.length, 0, oldTab.length);

        traverser.tab = new Object[8];
        traverser.pushState(oldTab, 0, oldTab.length);
        System.out.println(traverser);
        traverser.recoverState(8);
        System.out.println(traverser);
        traverser.recoverState(8);
        System.out.println(traverser);
    }
}
