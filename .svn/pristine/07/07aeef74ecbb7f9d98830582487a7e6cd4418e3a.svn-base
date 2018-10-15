package com.blibli.academy.project.Business.pojo;

import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;


/**
 * @author baich
 * 用户实体类
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 8098876831027177875L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


}
