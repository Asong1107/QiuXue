package com.blibli.academy.project.controller;


import com.blibli.academy.project.codeconst.ResponseVO;
import com.blibli.academy.project.dto.ArticleDto;
import com.blibli.academy.project.query.ArticleQuery;
import com.blibli.academy.project.service.StudentService;
import com.blibli.academy.project.util.FileSave;
import com.blibli.academy.project.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-18 18:20
 */
@Slf4j
@Api(tags = "StudentController", description = "文章视频api")
@RestController
public class StudentController {

    @Resource
    private StudentService studentService;
    @Resource
    FileSave fileSave;


    @ApiOperation(value = "分页条件查询", notes = "返回分页数据")
    @RequiresPermissions(".articles")
    @PostMapping("/root/articles")
    public Object Articles(@RequestBody ArticleQuery articleQuery) throws Exception {
        log.debug("articleQuery.toString" + articleQuery.toString());
        return ResultUtil.success("获取文章信息", studentService.findPageBreakByCondition(articleQuery));
    }


    @ApiOperation(value = "创建文章", notes = "返回信息")
    @RequiresPermissions(".articles")
    @PostMapping("/root/article")
    public ResponseVO createArticle(@RequestBody ArticleDto articleDto) throws Exception {
        log.debug("创建文章" + articleDto.toString());
        Map<String, Object> objectMap = new HashMap<String, Object>();
        objectMap.put("id", studentService.insertArticle(articleDto));
        return ResultUtil.success("文章创建成功", objectMap);
    }


    @ApiOperation(value = "上下架", notes = "返回结果")
    @ApiImplicitParam(name = "id", value = "文章id", required = true, paramType = "path", dataType = "Long", defaultValue = "1")
    @RequiresPermissions(".articles")
    @PutMapping("/root/article/{id}/status")
    public ResponseVO articleStatus(@Min(value = 0) @PathVariable("id") Long id) throws Exception {
        return ResultUtil.success("上下架文章", studentService.updateStatusByid(id));
    }


    @ApiOperation(value = "获取指定文章id", notes = "返回信息")
    @ApiImplicitParam(name = "id", value = "文章id", required = true, paramType = "path", dataType = "Long", defaultValue = "1")
    @RequiresPermissions(".articles")
    @GetMapping("/root/article/{id}")
    public ResponseVO getArticle(@PathVariable("id") Long id) throws Exception {
        ArticleQuery articleQuery = new ArticleQuery();
        articleQuery.setId(id);
        return ResultUtil.success("获取文章成功", studentService.findArticleById(id));
    }


    @ApiOperation(value = "更新文章数据", notes = "返回article信息")
    @ApiImplicitParam(name = "id", value = "文章id", required = true, paramType = "path", dataType = "Long", defaultValue = "1")
    @RequiresPermissions(".articles")
    @PutMapping("/root/articles/{id}")
    public ResponseVO updateArticle(@PathVariable("id") Long id, @RequestBody ArticleDto articleDto) throws Exception {
        articleDto.setId(id);
        return ResultUtil.success("更新文章", studentService.updateArticle(articleDto));
    }

}
