package com.blibli.academy.project.util;

import com.blibli.academy.project.Business.dto.WeixinAccessToken;
import com.blibli.academy.project.config.QiniuConfig;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 微信用户头像
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-21 01:58
 */
@Component
@Slf4j
public class WechatUserUtil {

    private static QiniuConfig qiniuConfig;
    @Autowired(required = true)
    public void setUserAccessor(QiniuConfig qiniuConfig) {
        WechatUserUtil.qiniuConfig = qiniuConfig;
    }

    private static final Logger logger = LoggerFactory.getLogger(WechatUserUtil.class);
    public static String downloadMedia (String accessToken, String mediaId) {
        try {
            accessToken = WeixinAccessToken.getAccessToken();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String fileUrl = null;
        // 拼接请求地址
        String requestUrl = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("MEDIA_ID", mediaId);
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setRequestMethod("GET");

            // 根据内容类型获取扩展名
            String fileExt = UpdateFileUtil.getFileExt(conn.getHeaderField("Content-Type"));
            // 将mediaId作为文件名
            String fileName = mediaId + fileExt;
            InputStream bis = conn.getInputStream();
            fileUrl = qiniuConfig.updateFileReal(bis, fileName);
            bis.close();
            conn.disconnect();
            logger.info("上传文件成功，fileName=" + fileName);
        } catch (Exception e) {
            String error = String.format("上传文件失败：%s", e);
            logger.error(error);
        }
        log.debug("fileUrl"+fileUrl);
        return fileUrl;
    }
}

