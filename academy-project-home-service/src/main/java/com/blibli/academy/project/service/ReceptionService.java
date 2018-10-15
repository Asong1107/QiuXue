package com.blibli.academy.project.service;




import com.blibli.academy.project.Business.dto.UserDto;
import com.blibli.academy.project.Business.pojo.UserVideo;
import com.blibli.academy.project.Business.pojo.Video;
import com.blibli.academy.project.codeconst.ResponseVO;
import com.blibli.academy.project.pojo.VideoQuery;
import com.github.pagehelper.PageInfo;

import java.text.ParseException;
import java.util.List;

/**
 * @author baich
 */
public interface ReceptionService {

   /**
    * 前台视频列表
    * @param videoQuery
    * @return
    */
   PageInfo<Video> getReceptionVideoList(VideoQuery videoQuery);

   /**
    *获取前台 视频详情
    */
   Video getVideoId(Long videoId,Long userId);

   /**
    * 获取当前用户和视频的点赞和收藏状态      和点赞和收藏数量
     */
   ResponseVO getVideoCode(UserVideo userVideo) throws ParseException;


   /**
    *前台签到逻辑 -----获取用户签到表的信息
    */
   ResponseVO getUserSignId(Long id);



   /**
    * 或取用户的历史签到信息
    */
   UserDto getHistorySignId(Long id);

   /**
    * banner视频查询接口
    */

   List<Video> getVideoBanner();
}
