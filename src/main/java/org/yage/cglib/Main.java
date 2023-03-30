package org.yage.cglib;

public class Main {
    public static class Father {
        public void say() {
            System.out.println("hello");
            this.hi();
        }

        public void hi() {
            System.out.println("hi");
        }
    }

    public static class ProxyClass extends Father {
        @Override
        public void say() {
            System.out.println("proxy say");
            super.say();
        }

        @Override
        public void hi() {
            System.out.println("proxy hi");
            super.hi();
        }
    }

    public static void main(String[] args) {
        ProxyClass proxyClass = new ProxyClass();
        proxyClass.say();
    }
}
