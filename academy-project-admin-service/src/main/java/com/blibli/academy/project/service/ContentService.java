package com.blibli.academy.project.service;



import com.blibli.academy.project.pojo.AddTeacherDto;
import com.blibli.academy.project.pojo.Teacher;
import com.blibli.academy.project.Business.pojo.Video;
import com.blibli.academy.project.pojo.VideoQuery;
import com.github.pagehelper.PageInfo;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author baich
 */

public interface ContentService<T,PK>{


    /**
     * 视频的新增
     */
    Video insertVideo(VideoQuery videoQuery) throws FileNotFoundException;

    /**
     * 视频列表的模糊查询
     */
//    List<Video> getVideoList(VideoQuery videoQuery);

    PageInfo<Video> getVideoList(VideoQuery videoQuery);

    /**
     * 视频上下架接口
     */
    void updateVideoStatus(Long videoId);

    /**
     * 老师信息保存
     * @param
     * @return
     */
    AddTeacherDto insertTeacher(AddTeacherDto entity) throws FileNotFoundException;


    /**
     * 查询教师 列表
     */
    List<Teacher> getTeacherList();

    /**
     * 老师删除   首先判断 是否有该老师的 视频作品
     * 有则 不能删除
     * 没有则删除
     */
    int getVideoTeacherId(Long id);

    Boolean deleteTeacherId(Long id);


    /**
     * 修改视频
     * @param videoQuery
     */
    Video updateVideo(VideoQuery videoQuery) throws FileNotFoundException;


    /**
     *后台视频详情接口
     */
    Video getVideosId(Long videoId);


}
