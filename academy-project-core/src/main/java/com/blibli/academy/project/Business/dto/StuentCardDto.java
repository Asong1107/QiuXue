package com.blibli.academy.project.Business.dto;

import lombok.Data;

/**
 * 学生证返回的信息
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-06 22:12
 */
@Data
public class StuentCardDto {

    private Long id;
    private String nickname; //姓名
    private String headImgUrl; //头像
    private Integer grade; //初一到高三
    private Integer data; //逆袭豆
    private Boolean binding; //绑定
    private String media_id;

}
