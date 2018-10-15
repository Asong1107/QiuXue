package com.blibli.academy.project.service;

import com.blibli.academy.project.Business.dto.ArticleDetaDto;
import com.blibli.academy.project.Business.dto.BannerDto;
import com.blibli.academy.project.Business.dto.HomeArticleDto;
import com.blibli.academy.project.codeconst.FindNull;
import com.blibli.academy.project.codeconst.RessNull;
import com.blibli.academy.project.query.PageQuery;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 前台文学部
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-25 14:45
 */
public interface ArticleService {
    //card文章列表 分页查询
    PageInfo<HomeArticleDto> findArticle(PageQuery pageQuery)throws FindNull;
    //获取文章详情
    ArticleDetaDto findByid(Long id,Long stu) throws RessNull;
    //点赞收藏
    Boolean updateLoveStatus(Long studyId,Long userId,Integer type);
    //bnner文章列表
    List<BannerDto> findArticleBanner(Integer num) throws Exception;

}
