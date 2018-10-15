package com.blibli.academy.project.query;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 视频文章查询条件
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-08 01:49
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class VideoQuery extends IQuer {
    @ApiModelProperty(notes = "文章类型id,1,banner,2:card",required = false)
    private Integer classify;
    @ApiModelProperty(notes = "年级id,0 所有,1-6年级",required = false)
    private Integer grade;
    @ApiModelProperty(notes = "学科id,0 所有,1-6学科",required = false)
    private Integer subject;
    @ApiModelProperty(notes = "用户id",required = true)
    private Long user_id;
    @JsonIgnore
    //文章视频类型
    private final Integer study_type = 2;
    @JsonIgnore
    //只查询文章上架的内容
    private final Boolean status = true;

}
