package org.yage.passwd;

import cn.hutool.core.text.PasswdStrength;
import org.jasypt.password.SEncryptor;

import javax.script.ScriptEngine;

/**
 * @author: Yage
 * @create: 2022-12-20 18:38
 */
public class Main {
    public static final String algorithm = "";
    public static final String encryptorPwd = "";
    public static final String passwd = "";

    public static void main(String[] args) {
        SEncryptor encryptor = new SEncryptor(algorithm);
        encryptor.setPassword(encryptorPwd);
        String pwd = encryptor.sDecrypt(passwd);
        System.out.println(pwd);
    }
}
