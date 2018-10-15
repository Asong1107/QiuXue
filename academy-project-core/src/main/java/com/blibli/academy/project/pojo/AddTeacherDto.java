package com.blibli.academy.project.pojo;


import lombok.Data;

/**
 * @author baich
 * 老师添加的传入类
 */
@Data
public class AddTeacherDto {

    private Long teacherId;
    private String imgUrl;
    private String teacherName;

}
