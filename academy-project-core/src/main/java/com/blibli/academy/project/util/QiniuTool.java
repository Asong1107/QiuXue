package com.blibli.academy.project.util;

import com.blibli.academy.project.config.TimeConfig;
import com.blibli.academy.project.properties.attribute.QiniuProperties;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static com.blibli.academy.project.codeconst.Stock.DEFAULT_TEMP_DIR;

/**
 *   接受 七牛的自定义参数-------重新封装
 * @author baich
 */

@Slf4j
@Configuration
public class QiniuTool {

    @Autowired
    private QiniuProperties qiniuProperties;

    @Autowired
    private TimeConfig timeConfig;


    /**
     * 认证信息实例
     */

    public Auth getAuth(){
        try{
            return  Auth.create(qiniuProperties.getAccess_key_id(),qiniuProperties.getAccess_key_secret());
        }catch (Exception e){
            log.info("七牛SDK的配置获取失败"+e);
            return null;
        }
    }
    /**
    *获取OSS指定地区节点配置
     * 华北机房
     */

    public com.qiniu.storage.Configuration qiNiuConfig(){
    return new com.qiniu.storage.Configuration(Zone.zone1());
    }

    /**
     * 构建一个七牛上传工具实例
     */

    public UploadManager uploadManager() {
        return new UploadManager(qiNiuConfig());
    }

    /**
     * 构建七牛空间管理实例
     */

    public BucketManager bucketManager() {
        return new BucketManager(getAuth(), qiNiuConfig());
    }


    /**
     * 获取上传凭证
     *
     * @return
     */
    private String getUploadToken() {
        return this.getAuth().uploadToken(qiniuProperties.getBucket_name());
    }


    public String updateFileName(String fileName) throws FileNotFoundException {
        //获取到临时文件
        File file = new File(DEFAULT_TEMP_DIR + fileName);
        log.info("上传文件---------" + file.getPath() );
        if(file.isFile() && file.exists()){
            //文件转换成输入流
            InputStream inputStream = new FileInputStream(file);
            //返回一个 输入流 和一个文件名。
            return updateFileReal(inputStream,fileName);
        }
        return null;
    }

    //通过文件输入流上传到七牛云------返回七牛的下载链接。

    public String updateFileReal(InputStream inputStream,String fileName){
        if(getAuth()!=null){
            if (uploadManager()!=null){
                try {
                    Response response = uploadManager().put(inputStream,fileName,getUploadToken(),null,null);
                    //解析上传结果
                    DefaultPutRet putRet = new Gson().fromJson((response).bodyString(),DefaultPutRet.class);
                    log.info("上传到七牛云的结果key-----" + putRet.key + "hash------"+putRet.hash);
                    timeConfig.getFileList().remove(fileName);
                    timeConfig.setFileList(fileName,new Date());
                    return qiniuProperties.getFile_url() + fileName;

                } catch (QiniuException e) {
                    e.printStackTrace();
                }

            }
        }
        return null;
    }

}
