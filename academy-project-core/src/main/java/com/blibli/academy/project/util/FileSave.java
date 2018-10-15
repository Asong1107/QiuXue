package com.blibli.academy.project.util;

import com.blibli.academy.project.codeconst.Stock;
import com.blibli.academy.project.config.TimeConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.Date;


/**
 * 图片上传到学院服务器 并返回路径
 * @author baich
 */
@Slf4j
@Component
public class FileSave {

    @Resource
    private TimeConfig timeConfig;

    public String saveFile(MultipartFile multipartFile)throws Exception{

        if(multipartFile == null){
            return null;
        }
        //文件的名称是 MD5字符串 加 文件后缀
        String fileName =Md5Util.getMultipartFileMD5(multipartFile) + UpdateFileUtil.getFileExt(multipartFile.getContentType());

        //文件 保存路径
        String savePath =Stock.DEFAULT_TEMP_DIR + fileName;
        File file = new File(savePath);
        log.info("保存路径-----"+file.getPath());
        multipartFile.transferTo(file);
        //图片保存半小时
        timeConfig.setFileList(fileName,new Date(System.currentTimeMillis() + 1800000));
        log.info("保存成功");
        return fileName;
    }
}
