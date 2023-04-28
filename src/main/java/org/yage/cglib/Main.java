package org.yage.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

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

    }

    @SuppressWarnings("unchecked")
    public static <T> T createProxyByCGlib(Class<T> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
            // 只代理需要代理的
            if (method.getName().equals("say")) {
                System.out.println("proxy " + method.getName());
                return proxy.invokeSuper(obj, args);
            }
            // 不需要代理的走默认值
            return proxy.invokeSuper(obj, args);
        });

        return (T) enhancer.create();
    }

    public static void main(String[] args) {
        ProxyClass proxyClass = new ProxyClass();
        proxyClass.say();

        System.out.println("========");
        Father proxyByCGlib = createProxyByCGlib(Father.class);

        proxyByCGlib.say();
    }
}
