package com.blibli.academy.project.Business.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-27 15:09
 */
@Data
public class TecherDto {
    @ApiModelProperty(notes = "id", required = false)
    private Long id;
    @NotBlank(message = "作者名称不能为空")
    @ApiModelProperty(notes = "名称", required = false)
    private String techer_name;
    @NotBlank(message = "头像地址不为空")
    @ApiModelProperty(notes = "头像地址", required = false)
    private String img_url;
}
