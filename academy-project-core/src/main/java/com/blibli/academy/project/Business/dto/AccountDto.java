package com.blibli.academy.project.Business.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-10 02:17
 */
@Data
@ApiModel(value = "Account",description = "账号")

public class AccountDto implements Serializable {

    private static final long serialVersionUID = -4839818108799795552L;
    @ApiModelProperty(notes = "id", required = false)
    private Long id;
    @ApiModelProperty(notes = "账号名", required = false)
    private String username;
    @ApiModelProperty(notes = "密码", required = false)
    private String password;
    @ApiModelProperty(notes = "老密码", required = false)
    private String oldPassword;
    @ApiModelProperty(notes = "角色名", required = false)
    private String rolename;
    // 角色名
    @ApiModelProperty(notes = "角色id", required = false)
    private Long role_id;
    @ApiModelProperty(notes = "创建时间", required = false)
    private Date createAt;
    @ApiModelProperty(notes = "创建人", required = false)
    private String createBy;

}
