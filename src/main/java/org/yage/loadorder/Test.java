package org.yage.loadorder;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author: Yage
 * @create: 2022-08-23 19:37
 */
public class Test {
    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL("https://hello.com/api/host?a=b&b=c");
        System.out.println(url.getPath());
        System.out.println(url.getQuery());
        System.out.println(url.getHost());
        System.out.println(url.getProtocol());
        System.out.println(Short.MAX_VALUE);
    }
}
