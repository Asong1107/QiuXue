package com.blibli.academy.project.Business.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;


/**
 * @author baich
 * 用户信息 签到
 */
@Data
public class UserDto {

    private Long id;
    private String openid;
    private String nickname;
    private String headImgUrl;
    private String email;
    private Long phone;
    private Integer data;
    private Integer grade;
    private Boolean status;
    private String address;
    private String createBy;
    private String updateBy;
    private Date createAt;
    private Date updateAt;
    private Boolean binding;

    /**
     * 签到
     */

    private Long lastSign;
    private String signDetails;
    private Long continuitySign;
    private Long historyHigh;

    private List<Integer> signDetail;


}
