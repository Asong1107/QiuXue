package com.blibli.academy.project.Business.dto;

import lombok.Data;

import java.util.Date;

/**
 * 前台文章详情
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-07 00:51
 */
@Data
public class HomeArticledetailsDto {
    private Long id;
    private String title; // 标题
    private String author; // 作者名称
    private Long video_time; //视频时长
    private String video_url;//视频url
    private String summary; // 简介
    private String covering; // 封面图片
    private String text; // 文章内容
    private Long collection; // 收藏数
    private Long love; // 点赞数
    private Date create_at; // 文章创建时间
    private Boolean praiseStatus; // 点赞状态
    private Boolean collectStatus; // 收藏状态

}
