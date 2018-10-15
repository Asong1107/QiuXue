package com.blibli.academy.project.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author baich
 * video查询传入表---继承分页查询的实体类
 */
@Data
public class VideoQuery extends Query implements Serializable  {

        private Long videoId;
        private Long type;
        private Long grade;
        private Long subject;
        private Long teacherId;
        private List<Integer> love;
        private Long status;
        private List<Integer> collection;

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

        private Long userId;
        private Long videoTime;
        private String teacherName;








    }
