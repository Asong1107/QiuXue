package com.blibli.academy.project.Business.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 老师信息
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-09 09:12
 */
@Data
public class Teacher implements Serializable {
    private static final long serialVersionUID = 11111L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String img_url;
    private String teacher_name;
    private Date create_at;
    private Date update_at;
    private String create_by;
    private String update_by;

}
