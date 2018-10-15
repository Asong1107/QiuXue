package com.blibli.academy.project.query;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Pattern;

/**
 * 用户搜索条件
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-13 13:51
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserQuery extends IQuer{

    @ApiModelProperty(notes = "昵称",required = false)
    private String nickname; //昵称
    @ApiModelProperty(notes = "email",required = false)
    @Email(message = "请输入正确格式的邮箱")
    private String email; //邮箱
    @ApiModelProperty(notes = "手机号", required = false)
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "手机号码格式错误")
    private String phone; //手机号
    @ApiModelProperty(notes = "逆袭豆范围", required = false, dataType = "Integer[]")
    private Integer[] data; //逆袭豆 数组包含一个搜索范围
    @ApiModelProperty(notes = "年级, 1-6对应不同年级, 0代表查询全部", required = false)
    private Integer grade; //年级
    @ApiModelProperty(notes = "所在地区", required = false)
    private String address; //所在区域
    @ApiModelProperty(notes = "冻结状态", required = false)
    private Boolean status; //用户状态
}
