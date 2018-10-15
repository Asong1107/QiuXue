package com.blibli.academy.project.Business.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 文章表
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-06 20:36
 */
@Data
public class Article implements Serializable {

    private static final long serialVersionUID = 1234556789L;
    @Id // 注意是 javax.persistence.Id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title; //标题
    private String summary; //简介
    private String text; // 正文
    private Integer classify; // card 文章0 banner文章1
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
