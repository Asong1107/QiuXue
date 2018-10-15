package com.blibli.academy.project.util;

/**
 * 文件上传工具
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-21 02:15
 */
public class UpdateFileUtil {
    /**
     * 根据内容类型判断文件扩展名
     *
     * @param contentType 内容类型
     * @return
     */
    public static String getFileExt(String contentType) {
        String fileExt = "";
        if ("image/jpeg".equals(contentType)) {
            fileExt = ".jpg";
        } else if("image/png".equals(contentType)) {
            fileExt = ".png";
        } else if("image/gif".equals(contentType)) {
            fileExt = ".gif";
        } else if ("audio/mpeg".equals(contentType)) {
            fileExt = ".mp3";
        } else if ("audio/amr".equals(contentType)) {
            fileExt = ".amr";
        } else if ("video/mp4".equals(contentType)) {
            fileExt = ".mp4";
        } else if ("video/mpeg4".equals(contentType)) {
            fileExt = ".mp4";
        }
        return fileExt;
    }
}
