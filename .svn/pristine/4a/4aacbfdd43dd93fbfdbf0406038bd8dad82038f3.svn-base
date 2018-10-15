package com.blibli.academy.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.blibli.academy.project.Business.pojo.Video;
import com.blibli.academy.project.codeconst.ResponseRowsVO;
import com.blibli.academy.project.codeconst.ResponseVO;
import com.blibli.academy.project.pojo.AddTeacherDto;
import com.blibli.academy.project.service.ContentService;
import com.blibli.academy.project.pojo.Teacher;
import com.blibli.academy.project.pojo.VideoQuery;

import com.blibli.academy.project.service.ReceptionService;
import com.blibli.academy.project.service.QiniuService;
import com.blibli.academy.project.util.FileSave;
import com.blibli.academy.project.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.util.*;


/**
 * @author baich
 */
@Api(tags = "ContentController",description = "老师和后台视频")
@RestController
@Slf4j
public class ContentController {

    @Autowired
    ContentService contentService;

    @Autowired
    ReceptionService receptionService;

    @Autowired
    QiniuService qiniuService;

    @Autowired
    private FileSave fileSave;


    private Map<String, Object> resultMap = new LinkedHashMap<>();


    /**
     * 视频后台新增
     * 接口已经 ----测试
     */
    @ApiOperation(value = "视频后台新增",notes = "返回状态码")
    @RequiresPermissions(".videos")
    @PostMapping("root/video/a")
    public ResponseVO insertVideo(@RequestBody VideoQuery videoQuery) throws FileNotFoundException {

           Video result =  contentService.insertVideo(videoQuery);
      return ResultUtil.success("反回链接------"+ result);
    }


    /**
     * 视频列表----加入   分页
     */
    @ApiOperation(value = "视频后台列表",notes = "返回分页列表")
    @RequiresPermissions(".videos")
    @PostMapping("root/video/list")
    public ResponseRowsVO getVideoList(@RequestBody VideoQuery videoQuery) {

        PageInfo<Video> pageInfo = contentService.getVideoList(videoQuery);
        log.info("数据输出----------"+ JSONObject.toJSONString(pageInfo));
        if(pageInfo.getTotal() != 0){
            return ResultUtil.success("视频列表",contentService.getVideoList(videoQuery));
        }else {
            log.info("");
            return ResultUtil.error("该搜索条件下没有数据",null);
        }
    }

    /**
     * 视频的上----下架----已测
     */
    @ApiOperation(value = "后台视频的上下架",notes = "返回状态码")
    @RequiresPermissions(".videos")
    @GetMapping("root/video/status/{videoId}")
    public ResponseVO updataVideoDownStatus(@PathVariable Long videoId) {
        contentService.updateVideoStatus(videoId);
        return ResultUtil.success("成功");
    }


    /**
     * 文件上传到服务器-------返回一个文件名----- 视频的banner图 ----已测试
     */
    @ApiOperation(value = "图片文件上传到服务器",notes = "返回状态码")
    @RequiresPermissions(".user")
    @PostMapping(value = "update/image")
    public ResponseVO updateFile(@RequestPart(required = true) MultipartFile updateImg) throws Exception {
        if(updateImg.isEmpty()){
            return ResultUtil.error("文件为空"); }
        String fileName = fileSave.saveFile(updateImg);
        resultMap.put("imageUrl",fileName);
        return ResultUtil.success("文件上传成功，请在半小时内提交呢数据",resultMap);
    }


    /**
     * 新增老师 ------通过 文件名 加真实目录  上传文件到七牛。--------已测试。
     */
    @ApiOperation(value = "修改账号的密码",notes = "新增老师的信息")
    @RequiresPermissions(".videos")
    @PostMapping("root/teacher/a")
  public ResponseVO createTeacher(@RequestBody @Valid AddTeacherDto addTeacherDto) throws FileNotFoundException {
      AddTeacherDto result = contentService.insertTeacher(addTeacherDto);
      return ResultUtil.success("创建老师成功",result); }


    /**
     * 老师列表---------已测
     */
    @ApiOperation(value = "老师列表",notes = "返回teachers")
    @RequiresPermissions(".videos")
    @GetMapping("root/teacher/list")
    public ResponseRowsVO findTeacherList() {
        try {
            List<Teacher> teachers = contentService.getTeacherList();
           return ResultUtil.success("老师列表",teachers);
        } catch (Exception e) {
           return ResultUtil.error("获取老师列表错误",null); }
    }



    /**
     * 删除老师 ------已测
     */
    @ApiOperation(value = "删除老师",notes = "返回状态码")
    @RequiresPermissions(".videos")
    @DeleteMapping("root/teacher/d/{teacherId}")
    public ResponseVO deleteTeacher(@PathVariable Long teacherId) {
        int number = contentService.getVideoTeacherId(teacherId);
        log.info("多少条数据--------" + number);
        if(number != 0){
            return ResultUtil.error("视频中有该老师的作品不得删除该老师");
        }else {
            contentService.deleteTeacherId(teacherId);
            return ResultUtil.success("删除老师成功");
        }
    }

    /**
     * 后台-----查看视频详情-------调用 前台视频详情接口----已测试
     */
    @ApiOperation(value = "查看视频详情",notes = "video")
    @RequiresPermissions(".videos")
    @GetMapping("root/video/{videoId}")
    public ResponseVO findVidoId(@PathVariable Long videoId){
        Video video = contentService.getVideosId(videoId);
        return ResultUtil.success("获取视频详情成功", video);
    }


    /**
     * 编辑 视频 -----首先调用查看视频详情的接口
     */

    @ApiOperation(value = "更新后台视频",notes = "视频信息")
    @RequiresPermissions(".videos")
    @PostMapping("root/video/e")
    public ResponseVO updateVideo(@RequestBody VideoQuery videoQuery) throws FileNotFoundException {

       Video result = contentService.updateVideo(videoQuery);
        return ResultUtil.success("修改视频成功---------",result);
    }





}