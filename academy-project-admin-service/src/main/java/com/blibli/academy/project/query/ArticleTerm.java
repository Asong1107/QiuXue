package com.blibli.academy.project.query;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文章列表查询条件
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-08 17:40
 */

@Data
@EqualsAndHashCode
public class ArticleTerm {
    @ApiModelProperty(notes = "标题",required = false)
    private String title;
    @ApiModelProperty(notes = "作者",required = false)
    private String author;
    @ApiModelProperty(notes = "点赞范围",required = false,dataType = "Interger[]")
    private Integer[] love;
    @ApiModelProperty(notes = "收藏范围",required = false,dataType = "Interger[]")
    private Integer[] collection;
    @ApiModelProperty(notes = "文章状态",required = false,dataType = "Boolean")
    private Boolean status;
    //文章类型
    @JsonIgnore
    private final Integer study_type = 1;
}
