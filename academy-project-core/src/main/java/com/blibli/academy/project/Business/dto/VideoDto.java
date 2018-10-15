package com.blibli.academy.project.Business.dto;

import lombok.Data;

import java.util.Date;

/**
 * 前台视频详情
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-08 01:39
 */
@Data
public class VideoDto {
    private Long id; // 查看时需要
    private String title; // 标题
    private String img_url;  // 作者图像
    private String teacher_name; // 作者名称
    private Long collection; // 收藏数
    private Long love; // 点赞数
    private String coverVideoUrl; //预览图
    private Date create_at; // 文章创建时间
    private String summary_video; // 视频文章简介
    private String covering; // 封面图
    private String video_url; // 视频Url
    private Date video_time; // 视频时长
    private Boolean loveStatus; // 点赞状态
    private Boolean collectStatus; // 收藏状态
    private Long articleId; //文章id

}
