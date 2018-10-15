package com.blibli.academy.project.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * 文章详情
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-08 17:03
 */
@Data
public class ArticleDto {

    private Long id;
    private String title; // 标题
    private String covering; // 封面
    private Integer classify; // 分类
    private String author;  // 作者
    private String introduce; // 摘要
    private String content; // 正文
    @JsonIgnore
    private final Integer study_type = 1;
    //默认状态
    private Boolean status = false;
}
