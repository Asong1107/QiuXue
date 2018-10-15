package com.blibli.academy.project.query;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 视频文章详情
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-07 20:58
 */


@ApiModel(value = "VideoQuery",description = "视频文章查询条件",parent = IQuer.class)
@Data
@EqualsAndHashCode(callSuper = false)
public class StudentQuery extends IQuer {

    public StudentQuery(){
        super();
    }
    public StudentQuery(String title, Integer classify, Integer grade, Integer subject, Integer[] love, Integer[] collect, String author, Boolean status){
        this.title = title;
        this.classify = classify;
        this.grade = grade;
        this.subject = subject;
        this.love = love;
        this.collect = collect;
        this.author = author;
        this.status = status;
    }
    @ApiModelProperty(notes = "标题",required = false)
    private String title;
    @ApiModelProperty(notes = "文章类型id,1,banner,2:card",required = false)
    private Integer classify;
    @ApiModelProperty(notes = "年级id,0,代表查询所有，1-6对应年级",required = false)
    private Integer grade;
    @ApiModelProperty(notes = "科目id，0 查询所有，1-6 对应科目",required = false)
    private Integer subject;
    @ApiModelProperty(notes = "点赞",required = false,dataType = "Integer[]")
    private Integer[] love;
    @ApiModelProperty(notes = "收藏",required = false,dataType = "Integer[]")
    private Integer[] collect;
    @ApiModelProperty(notes = "作者姓名",required = false)
    private String author;
    @ApiModelProperty(notes = "上下架状态",required = false)
    private Boolean status;
    @JsonIgnore
    private Integer study_type;
}
