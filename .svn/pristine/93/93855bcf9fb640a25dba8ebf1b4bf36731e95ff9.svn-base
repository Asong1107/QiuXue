package com.blibli.academy.project.service.impl;

import com.blibli.academy.project.Business.dto.AccountDto;
import com.blibli.academy.project.Business.enumerate.ClassifyEnum;
import com.blibli.academy.project.Business.enumerate.GradeEnum;
import com.blibli.academy.project.Business.enumerate.SubjectEnum;
import com.blibli.academy.project.dto.ClassifyDto;
import com.blibli.academy.project.service.ConService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-18 21:37
 */
@Slf4j
@Service
public class ConServiceImpl implements ConService {
    @Override
    public AccountDto getOnlineAccount() throws Exception {
        Subject subject = SecurityUtils.getSubject();
        return (AccountDto) subject.getPrincipal();
    }
}
