package com.blibli.academy.project.controller;

import com.blibli.academy.project.codeconst.FindNull;
import com.blibli.academy.project.codeconst.ResponseRowsVO;
import com.blibli.academy.project.codeconst.ResponseVO;
import com.blibli.academy.project.codeconst.RessNull;
import com.blibli.academy.project.query.PageQuery;
import com.blibli.academy.project.service.ArticleService;
import com.blibli.academy.project.util.ResultUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import java.util.Map;

/**
 * 前台文章视频
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-25 10:20
 */
@RestController
@Slf4j
public class ArticelController {
    @Resource
    ArticleService articleService;

    //获取文章列表
    @ApiOperation(value = "获取card文章列表", notes = "传入实体类")
    @PostMapping("/study/articles")
    public ResponseRowsVO getArticle(@ApiParam(name = "pageQuery", value = "实体类其中有每页显示的条数和要显示的页数") @RequestBody PageQuery pageQuery)throws FindNull {
        log.debug("获取文章列表"+ articleService.findArticle(pageQuery));
        return ResultUtil.success("获取card文章列表",articleService.findArticle(pageQuery));
    }
    //banner文章列表
    @ApiOperation(value = "获取banner文章信息", notes = "要显示的页数")
    @PostMapping("/article/banners")
    public ResponseRowsVO getBanner(@ApiParam @RequestBody Map<String,Integer> num)throws Exception{
        log.debug("num" + num.get("num"));
        return ResultUtil.success("获取banner文章",articleService.findArticleBanner(num.get("num")));
    }
    //文章详情
    @ApiOperation(value = "获取card文章详情信息", notes = "通过文章id获取详情")
    @PostMapping("/study/article/{id}")
    public ResponseVO getArticels(@Min(value = 0,message = "id不小于0")@PathVariable("id") Long id, @ApiParam(name = "stuId",value = "用户id",required = true) @RequestBody Map<String,Long> stuId) throws RessNull{
        log.debug("获取文章详情",articleService.findByid(id,stuId.get("studId")));
        return ResultUtil.success("获取card文章详情成功",articleService.findByid(id,stuId.get("stuId")));
    }
    //点赞
    @ApiOperation(value = "文章点赞操作", notes = "传入文章id和用户id-stuId点赞操作")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "文章id", required = true, paramType = "path", dataType = "Long"),
            @ApiImplicitParam(name = "stuId", value = "用户Id", required = true, dataType = "Long")
    })
    @PutMapping("/study/article/{id}/love")
    public ResponseVO updateStatus(@Min(value = 0,message = "id不能小于0")@PathVariable("id") Long id, @RequestBody Map<String,Long> stuId){
        return ResultUtil.success("点赞成功",articleService.updateLoveStatus(id,stuId.get("stuId"),1));
    }
    //收藏
    @ApiOperation(value = "文章收藏操作", notes = "传入视频id和用户id-stuId收藏操作")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", value = "文章id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "stuId", value = "用户Id", required = true, dataType = "Long")
    })
    @PutMapping("/study/article/{id}/collect")
    public ResponseVO updatStatus(@Min(value = 0,message = "id不能小于0")@PathVariable("id") Long id, @RequestBody Map<String,Long> stuId){
        return ResultUtil.success("收藏成功",articleService.updateLoveStatus(id,stuId.get("stuId"),2));
    }
}
