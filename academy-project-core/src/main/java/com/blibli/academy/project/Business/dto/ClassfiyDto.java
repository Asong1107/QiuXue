package com.blibli.academy.project.Business.dto;

import lombok.Data;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-15 00:43
 */
@Data
public class ClassfiyDto {
    // 分类名称, 根据类型查找分类的所有值
    private Integer id;
    private String name;
}
