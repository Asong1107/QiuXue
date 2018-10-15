package com.blibli.academy.project.Business.pojo;

import lombok.Data;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * 学生信息
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-07 16:16
 */
@Data
public class Student implements Serializable {

    private static final long serialVersionUID = 1234556789L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;//标题
    private String covering; //封面图
    private String author; //作者
    private Integer classify; //分类
    private Integer study_type; //类型 1 文章 2 视频
    private String introduce; //简介
    private String content; //正文
    private String video_url; //视频地址
    private Long video_time; //视频时长
    private Boolean status; //账号状态
    @Transient
    private Long love; //点赞数
    @Transient
    private Long collect; //收藏数
    private Integer grade;//年级
    private Integer subject; //科目
    private String create_by; //创建人
    private Date createAt;//创建时间
    private String update_by;//创建人
    private Date update_at;//更新时间

}
