package com.blibli.academy.project.Business.dto;

import lombok.Data;

/**
 * Banner图
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-08 01:21
 */
@Data
public class BannerDto {
    private Long id;
    //封面图
    private String covering;
    //标题
    private String title;
}
