package com.juaracoding.hkpujianta.ujianta.config;

import com.juaracoding.hkpujianta.ujianta.core.Crypto;

/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author pollc a.k.a. Paul Christian
Java Developer
Created on Fri 20:44
@Last Modified Fri 20:44
Version 1.0
*/
public class ContohConfig {
    private static String delay;
    private static String browser;
    private static int timeout;
    private static String url;
    private static String extUrl;
    private static String extUrl1;
    private static String password;

    public ContohConfig(String delay,
                        String browser,
                        int timeout,
                        String url,
                        String extUrl,
                        String extUrl1,
                        String password) {
        this.delay = delay;
        this.browser = browser;
        this.timeout = timeout;
        this.url = url;
        this.extUrl = extUrl;
        this.extUrl1 = extUrl1;
        this.password = Crypto.performDecrypt(password);
    }

    public static String getDelay() {
        return delay;
    }

    public static String getBrowser() {
        return browser;
    }

    public static int getTimeout() {
        return timeout;
    }

    public static String getUrl() {
        return url;
    }

    public static String getExtUrl() {
        return extUrl;
    }

    public static String getExtUrl1() {
        return extUrl1;
    }

    public static String getPassword() {
        return password;
    }
}