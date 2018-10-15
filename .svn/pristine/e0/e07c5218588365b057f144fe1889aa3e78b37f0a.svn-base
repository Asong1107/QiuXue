package com.blibli.academy.project.mapper;



import com.blibli.academy.project.pojo.Teacher;
import com.blibli.academy.project.Business.pojo.Video;
import com.blibli.academy.project.pojo.VideoQuery;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author baich
 */
@Repository
public interface ContentDao {

    /**
     * 获取视频banner的个数
     * @return
     */
    int getBannerCount();

    /**
     * 删除最早的banner
     */
    Boolean deleteUserVideo();

    Boolean deleteVideoId();



    /**
     * 视频的新增
     * @param video
     */

    void insertVideo(Video video);

    /**
     *
     * @param videoQuery  后台视频列表
     * @return
     */

    List<Video> getVideoList(VideoQuery videoQuery);


    /**
     * 视频上下架接口
     */
    void updateVideoStatus(Video video1);



    List<Teacher> getTeacherList();

    /**
     * 老师删除   首先判断 是否有该老师的 视频作品
     * 有则 不能删除
     * 没有则删除
     */
    int getVideoTeacherId(Long id);

    Boolean deleteTeacherId(Long id);


    /**
    * 老师新增
    */

    void insertTeacher(Teacher teacher);


    /**
    * 修改视频
    */

    void updateVideo(Video video);

    /**
     *后台视频详情
     */
    Video getVideosId(Long videoId);


}
