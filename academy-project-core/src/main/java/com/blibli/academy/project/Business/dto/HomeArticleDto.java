package com.blibli.academy.project.Business.dto;

import lombok.Data;

import java.util.Date;

/**
 * 首页文章列表
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-06 22:18
 */
@Data
public class HomeArticleDto {
    private Long id; // 查看时需要
    private String title; // 标题
    private String author;//作者
    private String introduce;//摘要
    private Integer love;//点赞数
    private Integer collect;//收藏数
    private Date createAt;//创建时间
    private String covering;//封面图
    private boolean loveStu;//点赞状态
    private boolean collectionStu;//收藏状态
}
