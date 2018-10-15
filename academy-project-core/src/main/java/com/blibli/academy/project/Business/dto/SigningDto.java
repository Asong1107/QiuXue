package com.blibli.academy.project.Business.dto;

import lombok.Data;

/**
 * 手机号绑定(校验验证码)
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-09 22:56
 */
@Data
public class SigningDto {
    private boolean state;
    private long gainBean;
    private Long code;
}
