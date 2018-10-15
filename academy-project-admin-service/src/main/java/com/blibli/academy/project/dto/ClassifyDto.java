package com.blibli.academy.project.dto;

import lombok.Data;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-27 14:49
 */
@Data
public class ClassifyDto {
    // 分类名称, 根据类型查找分类的所有值
    private Integer id;
    private String name;

}
