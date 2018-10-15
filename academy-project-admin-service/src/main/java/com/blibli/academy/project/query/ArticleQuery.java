package com.blibli.academy.project.query;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文章列表查询条件
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-08 17:40
 */
@ApiModel(value = "ArticleQuery",description = "文章查询条件",
        parent = IQuer.class)
@Data
@EqualsAndHashCode(callSuper = false)
public class ArticleQuery extends IQuer{
    @ApiModelProperty(notes = "标题",required = false)
    private String title;
    @ApiModelProperty(notes = "文章类型id,1:banners 2:card", required = false)
    private Integer classify;
    @ApiModelProperty(notes = "作者",required = false)
    private String author;
    @ApiModelProperty(notes = "点赞范围",required = false,dataType = "Interger[]")
    private Integer[] love;
    @ApiModelProperty(notes = "收藏范围",required = false,dataType = "Interger[]")
    private Integer[] collect;
    @ApiModelProperty(notes = "文章状态",required = false,dataType = "Boolean")
    private Boolean status;
    //文章类型
    @JsonIgnore
    private final Integer study_type = 1;
}
