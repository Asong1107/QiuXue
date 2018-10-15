package com.blibli.academy.project.controller;

import com.blibli.academy.project.codeconst.ResponseVO;
import com.blibli.academy.project.service.HomeUserService;
import com.blibli.academy.project.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-27 14:47
 */
@Api(tags = "CategoryController", description = "分类相关Api")
@RestController
public class ClassController {
    @Resource
    HomeUserService homeUserService;
    @ApiOperation(value = "获取枚举列表", notes = "根据传入分类名称返回分类对象")
    @ApiImplicitParam(name = "cName", value = "分类名称: article|grade|subject", required = true, paramType = "path", dataType = "String", defaultValue = "article")
    @GetMapping("/classify/{cName}")
    public ResponseVO getClassIfy(@NotNull(message = "分类名称不能为空") @PathVariable("cName") String cName) throws Exception {
        return ResultUtil.success("获取分类列表成功", (Object) homeUserService.findListByName(cName));
    }
}
