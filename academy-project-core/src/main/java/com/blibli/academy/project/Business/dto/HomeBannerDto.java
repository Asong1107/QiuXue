package com.blibli.academy.project.Business.dto;

import lombok.Data;

/**
 * banner文章
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-13 19:52
 */
@Data
public class HomeBannerDto {
    private String imgUrl; //banner图地址
    private Long id; //文章id
    private String title; //标题
}
