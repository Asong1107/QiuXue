package com.blibli.academy.project.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 通用条件查询
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-07 21:00
 */

@ApiModel(value = "IQuer",description = "条件查询")
@Data
abstract class IQuer {
    @ApiModelProperty(notes = "id",required = false)
    private Long id;
    @ApiModelProperty(notes = "每页数量",required = false)
    private Integer pageSize = 10;
    @ApiModelProperty(notes = "页数",required = false)
    private Integer pageNum = 1;

}
