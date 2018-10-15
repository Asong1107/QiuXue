package com.blibli.academy.project.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.blibli.academy.project.codeconst.RessNull;
import com.blibli.academy.project.service.SMSService;
import com.blibli.academy.project.util.SMSUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-24 16:41
 */
@Service
public class SMSServiceImpl implements SMSService {
    @Resource
    private SMSUtil smsUtil;
    @Override
    public Boolean sendSMS(Long id, String phoneId) throws ClientException, RessNull {
        return smsUtil.sendSms(id,phoneId);
    }
}
