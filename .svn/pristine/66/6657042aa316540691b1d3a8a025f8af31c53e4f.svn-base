package com.blibli.academy.project.mapper;

import com.blibli.academy.project.Business.dto.UserDto;
import com.blibli.academy.project.Business.pojo.User;
import com.blibli.academy.project.Business.pojo.UserSign;
import com.blibli.academy.project.Business.pojo.UserVideo;
import com.blibli.academy.project.Business.pojo.Video;
import com.blibli.academy.project.pojo.VideoQuery;
import java.util.List;


/**
 * @author baich
 * 前台Dao层
 */
public interface ReceptionDao {

    /**
     * @param videoQuery
     * @return
     * 获取前台视频列表
     */
    List<Video> getReceptionVideoList(VideoQuery videoQuery);

    /**
     *前台视频详情
     */

    Video getVideoId(Long videoId,Long userId);

    int getUserVideo (Long videoId,Long userId);

    /**
     * 获取当前用户和视频的点赞和收藏状态      和点赞和收藏数量
     * */
    Video getVideoCode(UserVideo userVideo);



    /**
     *更新用户的收藏码
     */
    void updateCollectionCode(UserVideo userVideo);

    /**
     *更新用户的 收藏数量
     */
    void updateVideoCollection(Video video1);



    /**
     * 更新用户的点赞码
     */
    void updateLoveCode(UserVideo userVideo);

    /**
     * 更新用户的点赞数量
     */
    void updateVideoLove(Video video1);

    /**
     * 插入用户点赞
     *
     */
    void insertLoveCode(UserVideo uservideo);

    /**
     * 插入用户收藏
     */
    void insertCollectionCode(UserVideo uservideo);

    /**
     * 前台的签到逻辑-----获取用户的签到表数据
     */
    UserSign getUserSignId(Long id);

    /**
     * 获取用户的逆袭豆数量
     */
    int getUserData(Long id);


    /**
     * 更新用户签到表
     */
    void updateUserSign(UserSign userSign1);

    /**
     * 更新用户表的逆袭豆数量
     */
    void updateUserData(User user1);

    /**
    * 插入用户签到连表数据
    */
    void insertUserSign(UserSign userSign1);

    /**
     * 获取用户的历史签到数据
     */

    UserDto getHistorySignId(Long id);


    /**
     * banner视频查询接口
     */
    List<Video> getVideoBanner();

}
