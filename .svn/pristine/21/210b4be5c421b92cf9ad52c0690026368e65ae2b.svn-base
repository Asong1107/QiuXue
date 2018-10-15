package com.blibli.academy.project.service.impl;


import com.blibli.academy.project.Business.dto.UserDto;
import com.blibli.academy.project.Business.pojo.User;
import com.blibli.academy.project.Business.pojo.UserSign;
import com.blibli.academy.project.Business.pojo.UserVideo;
import com.blibli.academy.project.Business.pojo.Video;
import com.blibli.academy.project.codeconst.ResponseVO;
import com.blibli.academy.project.mapper.ContentDao;
import com.blibli.academy.project.mapper.ReceptionDao;
import com.blibli.academy.project.pojo.VideoQuery;
import com.blibli.academy.project.service.ReceptionService;
import com.blibli.academy.project.tools.LoginName;
import com.blibli.academy.project.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author baich
 */
@Service("ForeService")
@Slf4j
public class ReceptionServiceImpl implements ReceptionService {

    @Resource
    ReceptionDao receptionDao;

    @Resource
    LoginName loginName;

    @Resource
    ContentDao contentDao;

    /**
     * 前台视频列表
     */
    @Override
    public PageInfo<Video> getReceptionVideoList(VideoQuery videoQuery){
        PageHelper.startPage(videoQuery.getPageNum(),videoQuery.getPageSize());
        List<Video> getReceptionVideoList = receptionDao.getReceptionVideoList(videoQuery);
        return  new PageInfo<>(getReceptionVideoList);}

    /**
     *获取前台视频详情
     */
    @Override
    public Video getVideoId(Long videoId,Long userId){
        if(receptionDao.getUserVideo(videoId,userId) != 0){
            return receptionDao.getVideoId(videoId,userId);
        }else {
            UserVideo userVideo = new UserVideo();
            userVideo.setVideoId(videoId);
            userVideo.setUserId(userId);
            userVideo.setLoveCode(0L);
            userVideo.setCollectionCode(0L);
            userVideo.setLoverAt(null);
            userVideo.setCollectionAt(null);
            receptionDao.insertLoveCode(userVideo);
        }
        return receptionDao.getVideoId(videoId,userId);
        }

    /**
     * 获取当前用户和视频的点赞和收藏状态      和点赞和收藏数量
     */
    @Override
    public ResponseVO getVideoCode(UserVideo userVideo) throws ParseException {

        Video video = receptionDao.getVideoCode(userVideo);
        Video video2;
        try{
        video2 = contentDao.getVideosId(userVideo.getVideoId());
        }catch (Exception e){
            return ResultUtil.error("没有此视频id");
        }

        System.out.println("查询用户点赞收藏的信息----"+video);

        Video video1= new Video();
        UserVideo uservideo = new UserVideo();

        uservideo.setUserId(userVideo.getUserId());
        uservideo.setVideoId(userVideo.getVideoId());

        System.out.println("查看输入的用户名-----"+ userVideo.getUserId());
        video1.setVideoId(userVideo.getVideoId());
        video1.setUpdateAt(loginName.newDate());

        if(video != null) {
            System.out.println("进入方法---------------------");
            if(userVideo.getType()==1){
                System.out.println("进入点赞方法------");
                if(video.getLoveCode()==1){
                    uservideo.setLoveCode(0L);
                    video1.setLove(video.getLove()-1);
                }  else {
                    uservideo.setLoveCode(1L);
                    video1.setLove(video.getLove()+1);
                }
                //更新用户的点赞
                uservideo.setLoverAt(loginName.newDate());
                receptionDao.updateLoveCode(uservideo);
                receptionDao.updateVideoLove(video1);
            }else {
                System.out.println("进入收藏方法------");
                if (video.getCollectionCode() == 1) {
                    System.out.println("取消收藏------" + video.getCollection());
                    uservideo.setCollectionCode(0L);
                    video1.setCollection(video.getCollection() - 1);
                } else {
                    System.out.println("添加收藏------"+video.getCollection());
                    uservideo.setCollectionCode(1L);
                    video1.setCollection(video.getCollection() + 1);
                }
                //更新用户的收藏
                uservideo.setCollectionAt(loginName.newDate());
                receptionDao.updateCollectionCode(uservideo);
                receptionDao.updateVideoCollection(video1);
            }
        }else {
            uservideo.setUserId(userVideo.getUserId());
            uservideo.setVideoId(userVideo.getVideoId());
            if(userVideo.getType()!= 1){
                uservideo.setCollectionCode(1L);
                uservideo.setLoveCode(0L);
                uservideo.setCollectionAt(loginName.newDate());
                uservideo.setLoverAt(null);
                video1.setCollection(video2.getCollection() + 1);


                receptionDao.insertLoveCode(uservideo);
                receptionDao.updateVideoCollection(video1);
            }else {
                uservideo.setCollectionCode(0L);
                uservideo.setLoveCode(1L);
                uservideo.setLoverAt(loginName.newDate());
                uservideo.setCollectionAt(null);
                video1.setLove(video2.getLove()+1);

                receptionDao.insertLoveCode(uservideo);
                receptionDao.updateVideoLove(video1);
            }
        }

        return ResultUtil.success("ture");
    }

    /**
     *前台签到逻辑 -----获取用户签到表的信息
     */
    @Override
    public ResponseVO getUserSignId(Long id){

        log.info("是否进入了签到系统-------------");
        UserSign userSign = receptionDao.getUserSignId(id);

        log.info("用户签到表的查询结果-----"+userSign);
        UserSign userSign1 = new UserSign();

        int data = receptionDao.getUserData(id);
        log.info("用户逆袭豆的数量-----"+ data);
        User user1 = new User();


        int num = loginName.newDateSign()-userSign.getLastSign().intValue();
        log.info("现在时间减去上次签到的时间-------时间差" + num);
        String sign = "0";
        if(num>1 && num < 31){
            //连续签到间断--非连续签到---
            log.info("进入间断签到方法---------");
            userSign1.setUserId(id);
            userSign1.setLastSign((long)loginName.newDateSign());
            userSign1.setContinuitySign(userSign.getContinuitySign()+1);
            userSign1.setHistoryHigh(userSign.getHistoryHigh());
            if(num>2) {
                //当间断时间大于2天时调用此方法 ， 间断一天时 为一个 0.
                for (int i = 0; i < num - 2; i++) {
                    sign = sign + "0";
                }
                log.info("签到详情的零---" + sign);
                userSign1.setSignDetails(userSign.getSignDetails() + sign + "1");
                receptionDao.updateUserSign(userSign1);
            }else {
                log.info("进入判断");
                userSign1.setSignDetails(userSign.getSignDetails() + "01");
                log.info("查看错误----"+ userSign.getSignDetails()+"01");
                receptionDao.updateUserSign(userSign1);
            }
            //逆袭豆的变化
            user1.setId(id);
            user1.setData(data+1);
            receptionDao.updateUserData(user1);
        }else if(num>=31){
            //时间差大于或等于31 时 说明是 上个月签到 或者第一次签到 历史最高 为1
            log.info("进入第一次签到方法---------");
            userSign1.setUserId(id);
            userSign1.setLastSign((long)loginName.newDateSign());
            userSign1.setHistoryHigh(1L);
            userSign1.setContinuitySign(userSign.getContinuitySign()+1);
            if(loginName.newDateSignDay()>2) {
                for (int i = 0; i < loginName.newDateSignDay() - 2; i++) {
                    sign = sign + "0";
                }
                log.info("签到详情-----" + sign);
                userSign1.setSignDetails(sign + "1");
            }else if(loginName.newDateSignDay()==1){
                userSign1.setSignDetails("1");
            }else {userSign1.setSignDetails("01");}
            receptionDao.updateUserSign(userSign1);
            //逆袭豆的变化
            user1.setId(id);
            user1.setData(data+1);
            receptionDao.updateUserData(user1);
        }else if(num != 0) {
            //连续签到
            userSign1.setUserId(id);
            userSign1.setLastSign((long) loginName.newDateSign());
            userSign1.setSignDetails(userSign.getSignDetails() + "1");
            userSign1.setHistoryHigh(userSign.getHistoryHigh() + 1);
            userSign1.setContinuitySign(userSign.getContinuitySign() + 1);
            receptionDao.updateUserSign(userSign1);
            String s = userSign.getSignDetails();
            int n = 5;
            String ss = s.substring(s.length() - n, s.length());
            log.info("打印后5位字符串" + ss);
            //打印最右边为0的字符串的位置
            int number = ss.lastIndexOf("0");
            log.info("打印搜索到0 的位数" + number);
            user1.setId(id);
            if (number <= 3 && number > 0) {
                user1.setData(data + 5 - number);
                receptionDao.updateUserData(user1);
                return ResultUtil.success("签到成功", 5 - number);
            } else {
                user1.setData(data + 5);
                receptionDao.updateUserData(user1);
                return ResultUtil.success("签到成功", 5);
            }
        } else {
            return ResultUtil.error("今天已经签过倒啦。。");
        }
        //非连续签到 逆袭豆加1
        return ResultUtil.success("签到成功",1);
    }


    /**
     * 或取用户的历史签到信息
     * 当用户签到表没有 这个用户时 添加默认;
     */
    @Override
    public UserDto getHistorySignId(Long id){
        UserSign userSign1 = new UserSign();
        if(receptionDao.getUserSignId(id) == null){
            userSign1.setUserId(id);
            userSign1.setHistoryHigh(0L);
            userSign1.setContinuitySign(0L);
            userSign1.setLastSign(0L);
            receptionDao.insertUserSign(userSign1);
        }
    UserDto userDto = receptionDao.getHistorySignId(id);
        String str = userDto.getSignDetails();
        int[] intArray = new int[str.length()];
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < str.length(); i++) {

            Character ch = str.charAt(i);
            intArray[i] = Integer.parseInt(ch.toString());
        }
        for (int i = 0; i < intArray.length; i++) {
            list.add(intArray[i]);
        }
        System.err.print(list);
        userDto.setSignDetail(list);
        return userDto;
    }




    /**
     * banner视频查询接口
     */

    @Override
    public List<Video> getVideoBanner(){return receptionDao.getVideoBanner();}


}
