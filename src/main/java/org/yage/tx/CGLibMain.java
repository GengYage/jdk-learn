package org.yage.tx;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: Yage
 * @create: 2023-01-31 14:03
 */
public class CGLibMain {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CGLibMain.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                if (method.getName().equals("hello")) {
                    System.out.println(this);
                    System.out.println(obj);
                    System.out.println("== before -==");
                    proxy.invokeSuper(obj, args);
                    System.out.println("== after ==");
                }
                return null;
            }
        });

        CGLibMain o = (CGLibMain) enhancer.create();
        o.hello();

        CGLibMain cgLibMain = new CGLibMain();
        cgLibMain.hello();
    }

    public void hello() {
        System.out.println("this:" + this);
    }
}
