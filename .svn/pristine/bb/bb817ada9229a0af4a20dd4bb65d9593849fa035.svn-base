package com.blibli.academy.project.util;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-07 16:10
 */
@Slf4j
public class Md5Util {

    public final static String stringToMD5(String s){
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        byte[] btInput = s.getBytes();
        MessageDigest mdInst = null;
        try {
            // 获得MD5摘要算法的 MessageDigest 对象
            mdInst = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 使用指定的字节更新摘要
        mdInst.update(btInput);
        // 获得密文
        byte[] md = mdInst.digest();
        // 把密文转换成十六进制的字符串形式
        int j = md.length;
        char str[] = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte byte0 = md[i];
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(str);
    }
  /**
     * 把文件 通过 文件流MD5 加密成 唯一的字符串  防止文件 名重复
     * @param multipartFile
     * @return
     */
    public final static String getMultipartFileMD5(MultipartFile multipartFile){
        try {
            byte[] uploadBytes = multipartFile.getBytes();
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(uploadBytes);
            String filename = new BigInteger(1, digest).toString(16);
            return filename;
        } catch (Exception e) {
            log.debug("MD5获取失败");
        }
        return null;
    }
}
