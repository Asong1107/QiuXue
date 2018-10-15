package com.blibli.academy.project.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.blibli.academy.project.pojo.AddTeacherDto;
import com.blibli.academy.project.service.ContentService;
import com.blibli.academy.project.mapper.ContentDao;
import com.blibli.academy.project.pojo.Teacher;
import com.blibli.academy.project.Business.pojo.Video;
import com.blibli.academy.project.pojo.VideoQuery;
import com.blibli.academy.project.service.QiniuService;
import com.blibli.academy.project.tools.LoginName;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

/**
 * @author baich
 */
@Service
@Slf4j
public class ContentServiceImpl implements ContentService {


    @Autowired
    private ContentDao contentDao;

    @Resource
    private QiniuService qiniuService;

    @Resource
    private LoginName loginName;


    /**
     * 后台视频的新增
     * @param videoQuery
     * @return
     * @throws FileNotFoundException
     */
    @Override
    public Video insertVideo(VideoQuery videoQuery) throws FileNotFoundException {
            if(videoQuery.getType()==2) {
                videoQuery.setBannerUrl(qiniuService.updateFile(videoQuery.getBannerUrl()));
            }else {
                videoQuery.setCover(qiniuService.updateFile(videoQuery.getCover()));
            }
        Video video = new Video();
        //dto的属性拷贝到 teacher实体类中，大大的节省代码-----
        BeanUtils.copyProperties(videoQuery,video);
        video.setCreateAt(new Date());
        video.setUpdateAt(new Date());
        video.setCreateBy(loginName.loginName());
        video.setUpdateBy(loginName.loginName());
        video.setStatus(1L);
        if(videoQuery.getType()!=1 && contentDao.getBannerCount()>=8 ){
            log.debug("输出banner的数目"+ contentDao.getBannerCount());
            contentDao.deleteUserVideo();
            contentDao.deleteVideoId();
            log.debug("删除成功----------");
        }
        contentDao.insertVideo(video);
        return video;
        }

    /**
     * @param videoQuery 后台视频列表
     * @return
     */
    @Override
    public PageInfo<Video> getVideoList(VideoQuery videoQuery){
        PageHelper.startPage(videoQuery.getPageNum(),videoQuery.getPageSize());
        List<Video> videoList = contentDao.getVideoList(videoQuery);
        System.out.println("输出查询出的数据---------"+ JSONObject.toJSONString(videoList));

        return new PageInfo<>(videoList);
    }


    /**
     * 视频上下架接口
     */
    @Override
    public void updateVideoStatus(Long videoId){
        Video video = contentDao.getVideosId(videoId);
        log.info("videoId的状态------"+video);
        Video video1 = new Video();
        video1.setVideoId(videoId);
        if(video.getStatus() != 1){
            video1.setStatus(1L);
        }else {
            video1.setStatus(0L);
        }
        contentDao.updateVideoStatus(video1)
        ;}

    /**
     * 老师信息保存------
     * @return
     */
    @Override
    public AddTeacherDto insertTeacher(AddTeacherDto entity) throws FileNotFoundException {
        if(!"".equals(entity.getImgUrl()) && entity.getImgUrl() != null){
            //将文件上传到七牛-------返回七牛的下载链接
            entity.setImgUrl(qiniuService.updateFile(entity.getImgUrl()));
        }

        Teacher teacher =  new Teacher();
        //dto的属性拷贝到 teacher实体类中，大大的节省代码-----
        BeanUtils.copyProperties(entity,teacher);
        teacher.setCreateAt(new Date());
        teacher.setUpdateAt(new Date());
        teacher.setCreateBy(loginName.loginName());
        teacher.setUpdateBy(loginName.loginName());
        contentDao.insertTeacher(teacher);
        BeanUtils.copyProperties(teacher,entity);
        //返回一个带 url的实体类
        return entity;
    }

    /**
     * 查询老师列表
     * @return
     */
    @Override
    public List<Teacher> getTeacherList()
    { return contentDao.getTeacherList();}

    /**
     * 老师删除   首先判断 是否有该老师的 视频作品
     * 有则 不能删除
     * 没有则删除
     */
    @Override
    public int getVideoTeacherId(Long id){return contentDao.getVideoTeacherId(id);}
    @Override
    public Boolean deleteTeacherId(Long id){return contentDao.deleteTeacherId(id);}



    /**
     * 修改视频----上传图片-------未测试
     */
    @Override
    public Video updateVideo(VideoQuery videoQuery) throws FileNotFoundException {
            if(videoQuery.getType()==2) {
                videoQuery.setBannerUrl(qiniuService.updateFile(videoQuery.getBannerUrl()));
            }else {
                videoQuery.setCover(qiniuService.updateFile(videoQuery.getCover()));
            }

        Video video = new Video();
        BeanUtils.copyProperties(videoQuery,video);
        video.setUpdateBy(loginName.loginName());
        video.setUpdateAt(new Date());
        if(videoQuery.getType()!=1 && contentDao.getBannerCount()>=8 ){
            contentDao.deleteUserVideo();
            contentDao.deleteVideoId();
        }
        contentDao.updateVideo(video);
        return video;
    }

    /**
     * 后台视频详情接口
     * @param videoId
     * @return
     */
    @Override
    public Video getVideosId(Long videoId){return contentDao.getVideosId(videoId);}


}
