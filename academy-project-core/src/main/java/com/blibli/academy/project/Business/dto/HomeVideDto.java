package com.blibli.academy.project.Business.dto;

import java.util.Date;

/**
 * 用户收藏视频
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-22 17:30
 */
public class HomeVideDto {
    private Long id;
    private String title; //标题
    private String teacher_name;//老师姓名
    private String text_video;//摘要
    private String video_url; //视频地址
    private Long video_time; //视频时长
    private Boolean praiseStatus; // 点赞状态
    private Boolean collectStatus; // 收藏状态
    private String cover; //封面图
    private Long love; //点赞数
    private Long collect; //收藏数
    private Date createTime; //收藏时间
}
