package com.blibli.academy.project.service.impl;

import com.blibli.academy.project.service.QiniuService;
import com.blibli.academy.project.util.QiniuTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;


/**
 * @author baich
 * 调用七牛接口实现
 */
@Slf4j
@Service("qiniu")
public class QiniuServiceImpl implements QiniuService {

    @Autowired
    QiniuTool qiniuTool;

    @Override
    public String updateFile(String fileName) throws FileNotFoundException {
        return qiniuTool.updateFileName(fileName);
    }

}
