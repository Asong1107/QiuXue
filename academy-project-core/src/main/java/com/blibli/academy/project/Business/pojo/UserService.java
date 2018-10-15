package com.blibli.academy.project.Business.pojo;


import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author baich
 * 后台管理员实体类
 */
@Data
public class UserService implements Serializable {

    private Long id;
    private String username;
    private String password;
    private Long roleId;
    private Long phone;
    private int status;
    private String createBy;
    private String updateBy;
    private Date createAt;
    private Date updateAt;


    private String roleName;
    private List<Module> modules;
    private String upPwd;
    private String secondPwd;

}
