package com.blibli.academy.project.controller;


import com.blibli.academy.project.Business.dto.UserDto;
import com.blibli.academy.project.Business.pojo.*;
import com.blibli.academy.project.codeconst.ResponseVO;
import com.blibli.academy.project.pojo.VideoQuery;
import com.blibli.academy.project.service.ReceptionService;
import com.blibli.academy.project.tools.LoginName;
import com.blibli.academy.project.util.ResultUtil;
import com.blibli.academy.project.codeconst.ResponseRowsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;



/**
 * @author baich
 */
@Slf4j
@Api(tags = "RceptionController", description = "前台视频Api")
@RestController
public class ReceptionCollection {

    @Autowired
    ReceptionService receptionService;
    @Autowired
    LoginName loginName;



    /**
     * 前台视频列表展示----card ---已测-----
     * @param videoQuery
     * @return
     */
    @ApiOperation(value = "card视频列表",notes = "反回列表数据")
    @PostMapping("user/video/list")
    public ResponseRowsVO getReceptionService(@ModelAttribute VideoQuery videoQuery){
           return ResultUtil.success("获取前台列表数据成功",receptionService.getReceptionVideoList(videoQuery));
    }

    /**
     * 前台视频详情-------已测
     */
    @ApiOperation(value = "前台视频详情",notes = "反回详情数据")
    @GetMapping("user/video/{videoId}/{userId}")
    public ResponseVO getVideoId(@PathVariable Long videoId,@PathVariable("userId")Long userId){
        log.info("接值--------"+ videoId +"----------"+userId);
            Video video = receptionService.getVideoId(videoId,userId);
            log.info("输出----------"+video);
            return ResultUtil.success("查看详情----" , video);
    }


    /**
     * 前台视频 点赞和收藏   -------------已测
     * 接口传递数据
     *    "type":1,
     *    "userId":"66",
     *     "videoId":1
     */
    @ApiOperation(value = "前台视频的点赞",notes = "数据")
    @PostMapping("user/video/type")
    public ResponseVO videoCollection(@RequestBody UserVideo userVideo) throws ParseException {
        log.info("进入总方法------");
        return receptionService.getVideoCode(userVideo);
    }


    /**
     * 前台的签到系统  ----------已测试
     */
    @ApiOperation(value = "签到系统",notes = "签到值")
    @GetMapping("user/sign/{id}")
    public ResponseVO userSign(@PathVariable Long id){ return receptionService.getUserSignId(id); }



    /**
     * 前台历史签到展示
     */
    @ApiOperation(value = "首页的签到",notes = "历史签到值")
    @GetMapping("user/historySign/{id}")
    public ResponseVO historySign(@PathVariable Long id){
        UserDto userDto = receptionService.getHistorySignId(id);
        return ResultUtil.success("获取用户的历史签到数据成功",userDto);

    }


    /**
     * 视频 ------- 前台----banner-----已测
     */
    @ApiOperation(value = "banner视频列表",notes = "videoBanner")
    @GetMapping("user/video/banner")
    public ResponseRowsVO getVideoBanner(){
        List<Video> videobanner = receptionService.getVideoBanner();
        return ResultUtil.success("获取banner成功",videobanner);
    }
}
