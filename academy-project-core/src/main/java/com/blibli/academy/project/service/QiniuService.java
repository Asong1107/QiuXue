package com.blibli.academy.project.service;


import java.io.FileNotFoundException;

/**
 * @author baich
 *  图片上传接口
 *  从这个接口调用七牛上传接口
 */
    public interface QiniuService {

        String updateFile(String fileName) throws FileNotFoundException;

}