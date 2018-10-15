package com.blibli.academy.project.util;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * 微信工具依赖
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-20 21:05
 */
public class MyX509TrustManager implements X509TrustManager {

    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }


    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }


    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
