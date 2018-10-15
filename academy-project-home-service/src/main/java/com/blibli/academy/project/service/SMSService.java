package com.blibli.academy.project.service;

import com.aliyuncs.exceptions.ClientException;
import com.blibli.academy.project.codeconst.RessNull;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-24 16:41
 */
public interface SMSService {

    Boolean sendSMS(Long id, String phoneId) throws ClientException, RessNull;
}
