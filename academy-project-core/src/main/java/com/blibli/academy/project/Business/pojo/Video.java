package com.blibli.academy.project.Business.pojo;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;


/**
 * @author baich
 * 视频实体类
 */
@Data
public class Video implements Serializable {

    private Long videoId;
    private Long type;
    private Long grade;
    private Long subject;
    private Long teacherId;
    private Long love;
    private Long status;
    private Long collection;

    private String title;
    private String videoUrl;
    private String cover;
    private String summaryVideo;
    private String textVideo;
    private String bannerUrl;
    private String createBy;
    private String updateBy;
    private Date createAt;
    private Date updateAt;
    private Long videoTime;

//收藏和点赞的列表状态

    private Long collectionCode = 0L;
    private Long loveCode =0L;
    private String teacherName;
    private String imgUrl;

}
