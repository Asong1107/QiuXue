package com.blibli.academy.project.Business.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 *
 * 账户信息
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-10 02:35
 */
@Data
public class Account {
    private static final long serialVersionUID = 1234556789L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private Long role_id;
    private Date create_at;
    private Date update_at;
    private String create_by;
    private String update_by;
}
