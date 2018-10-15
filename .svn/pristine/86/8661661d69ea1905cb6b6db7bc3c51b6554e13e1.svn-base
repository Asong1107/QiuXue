package com.blibli.academy.project.controller;

import com.blibli.academy.project.Business.dto.HomeVideDto;
import com.blibli.academy.project.Business.pojo.Video;
import com.blibli.academy.project.businsess.Dto.StudentDto;
import com.blibli.academy.project.codeconst.ResponseRowsVO;
import com.blibli.academy.project.codeconst.ResponseVO;
import com.blibli.academy.project.codeconst.RessNull;
import com.blibli.academy.project.service.StudentService;
import com.blibli.academy.project.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-20 15:41
 */
@RestController
@Api(tags = "StudentController", description = "学生证相关API")
@Slf4j
@Validated
public class  StudentController {
    @Autowired
    StudentService studentService;

    @ApiOperation(value = "学生证首页",notes = "通过用户id获取首页信息")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path", dataType = "long")
    @GetMapping("/user/{id}")
    public ResponseVO studentcard(@Min(value = 0,message = "参数不小于0")@PathVariable("id") Long id)throws Exception{
        log.info("获取用户首页签到信息传入",+ id);
        return ResultUtil.success("学生证首页查询",studentService.selectAll(id));
    }
    @ApiOperation(value = "学生证用户绑定信息", notes = "通过用户ID获取首页信息")
    @ApiImplicitParam(name = "id",value = "用户id",required = true,paramType = "path",dataType = "long")
    @GetMapping("/user/card/binding/{id}")
    public ResponseVO studentBind(@Min(value = 0,message = "参数不小于0")@PathVariable("id") Long id)throws Exception{
        log.info("学生证用户传入的绑定的信息"+id);
        return ResultUtil.success("学生证查看是否绑定",studentService.selectBinding(id));
    }
    @ApiOperation(value = "学生证资料编辑", notes = "需要传用户头像")
    @PutMapping("/user/student/{id}")
    public ResponseVO updateStudentCard(@Min(value = 0,message = "参数不能小于0")@PathVariable("id") Long id, @RequestBody @ApiParam(name = "用户对象",value = "传入json格式",required = true) StudentDto studentDto) throws RessNull {
        log.info("学生证资料编辑传入的参数："+id);
        studentDto.setId(id);
        String string = studentService.updateStudent(studentDto);
        return ResultUtil.success("学生资料修改",string);
    }

    @ApiOperation(value = "获取收藏文章信息", notes = "传入用户ID返回收藏文章列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用户id", paramType = "path", required = true, dataType = "Long"), @ApiImplicitParam(name = "pageNum", value = "显示的页数", required = true, dataType = "int")})
    @PostMapping("/user/article/c/{id}")
    public ResponseRowsVO getArticles(@Min(value = 0,message = "id参数不能小于0")@PathVariable("id")Long id, @RequestBody Map<String,Integer> pageNum)throws RessNull {
        log.debug("获取文章收藏的信息"+ id +"传入页面的信息:"+ pageNum);
        return ResultUtil.success("用户收藏文章的信息成功",studentService.findCollectArticle(id,pageNum.get("pageNum")));
    }
    @ApiOperation(value = "获取收藏视频的信息",notes = "传入用户id返回收藏视频列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "userId", value = "用户id", paramType = "path", required = true, dataType = "Long"), @ApiImplicitParam(name = "pageNum", value = "显示的页数", required = true, dataType = "int")})
    @PostMapping("/user/video/c/{userId}")
    public ResponseRowsVO getVideo(@Min(value = 0,message = "参数不能小于0")@PathVariable("userId")Long userId,@RequestBody Map<String,Integer> pageNum)throws RessNull {
        PageInfo<Video> pageInfo = studentService.findCollectVideo(userId, pageNum.get("pageNum"));
        if (pageInfo.getTotal() != 0) {
            return ResultUtil.success("用户收藏视频", pageInfo);
        }else {
            return ResultUtil.error("用户收藏失败",null);
        }
    }

}
