package com.blibli.academy.project.Business.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author baich
 * 模块儿实体类
 */
@Data
public class Module implements Serializable {

private Long id;
private String name;
private String url;
private String permission;
private Long parentId;
private String createBy;
private String updateBy;
private Date createAt;
private Date updateAt;

}
