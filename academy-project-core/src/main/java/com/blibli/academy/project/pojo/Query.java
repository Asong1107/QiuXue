package com.blibli.academy.project.pojo;

import lombok.Data;

/**
 * 封装的分页查询的 抽象类
 */
@Data
abstract class Query {

    private Long id;

    private Integer pageSize =10;

    private Integer pageNum =1;
}
