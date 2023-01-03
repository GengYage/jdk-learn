package org.yage.passwd;

import cn.hutool.core.text.PasswdStrength;

import javax.script.ScriptEngine;

/**
 * @author: Yage
 * @create: 2022-12-20 18:38
 */
public class Main {
    public static final String algorithm = null;
    public static final String encryptorPwd = null;

    public static void main(String[] args) {
        SEncryptor encryptor = new SEncryptor(algorithm);
        encryptor.setPassword(encryptorPwd);
    }
}
