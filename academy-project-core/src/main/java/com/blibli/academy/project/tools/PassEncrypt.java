package com.blibli.academy.project.tools;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author baich
 *  shiro  密码加密的工具类 的封装
 */

public class PassEncrypt {

    public static  String  PasswordEncrypt(String username,String password) {
        //加密方式
        String algorithmName="MD5";

        //加密的字符串


        //盐值，用于和密码混合起来用
        ByteSource salt = ByteSource.Util.bytes(username);

        //加密的次数,可以进行多次的加密操作
        int hashIterations = 1;

        //通过SimpleHash 来进行加密操作
        SimpleHash hash = new SimpleHash(algorithmName, password, salt, hashIterations);

        System.out.println(hash.toString());
        return hash.toString();
    }


}
