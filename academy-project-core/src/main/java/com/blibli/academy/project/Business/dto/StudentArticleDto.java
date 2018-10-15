package com.blibli.academy.project.Business.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-09 23:56
 */
@Data
public class StudentArticleDto {
    private Long id;
    private String covering;
    private String title;
    private String teacher_name;
    private long love;
    private String introduce;
    private long collect;
    private Date createAt;
    private Boolean loveStatus; // 点赞状态
    private Boolean collectStatus; // 收藏状态

}
