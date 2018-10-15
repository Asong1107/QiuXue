package com.blibli.academy.project.dto;

import lombok.Data;

import java.util.Date;

/**
 * 视频列表数据
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-15 15:18
 */
@Data
public class VideoListDto {
    private Long id;
    private String title;
    private String classify;
    private String teacher_name;
    private Long love;
    private Long collect;
    private Boolean status;
    private String grade;
    private String subject;
    private Date update_at;
}
