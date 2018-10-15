package com.blibli.academy.project.Business.dto;

import lombok.Data;

import java.util.Date;

/**
 * 视频文章数据
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-06 22:15
 */
@Data
public class StudentVideoDto {
    private Long id;
    private String title; //标题
    private String summary_video; //视频简介
    private String text; // 正文
    private Integer study_type; // card 文章0 banner文章1
    private String covering; //封面图片
    private String author; //作者
    private int collection; //收藏数
    private int love; //点赞数
    private int status; //状态码
    private String create_by; //创建人
    private String update_by; //修改人
    private Date create_at; //创建时间
    private Date update_at; //修改时间
}
