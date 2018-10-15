package com.blibli.academy.project.mapper;

import com.blibli.academy.project.Business.dto.*;
import com.blibli.academy.project.Business.pojo.Student;
import com.blibli.academy.project.Business.pojo.Video;
import com.blibli.academy.project.query.StudentQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.blibli.academy.project.mapperplus.BaseMapper;

import java.util.Date;
import java.util.List;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-17 18:16
 */
@Repository
public interface StudentDao extends BaseMapper<Student>{
    //获取文章后台集合
    List<StudentDto> findPageBreakByCondition(StudentQuery studentQuery)throws NullPointerException;
    //更改文章状态
    Boolean updateStatusByid(Long id);
    //用户文章收藏集合
    List<StudentArticleDto> findCollectArticle(@Param("id")Long id);

    List<Video> findCollectVideo(@Param("userId")Long userId);
    //Banner文章
    List<BannerDto> findArticleBanner(@Param("num") Integer num);
    //获取前台文章集合
    List<HomeArticleDto> findArticelList();
    //获取文章详情
    ArticleDetaDto findCardByid(@Param("studyId") Long studyId,@Param("userId") Long userId);
    //查询点赞收藏状态
    Boolean findLoveStatus(@Param("studyId") Long studyId,@Param("userId") Long userId,@Param("type") Integer type);
    //取消点赞收藏
    Boolean deleteLoveStatus(@Param("studyId") Long studyId,@Param("userId") Long userId,@Param("type") Integer type);
    //点赞收藏
    Boolean insertLoveStatus(@Param("studyId") Long studyId, @Param("userId") Long userId, @Param("type") Integer type, @Param("createAt")Date createAt);
}
