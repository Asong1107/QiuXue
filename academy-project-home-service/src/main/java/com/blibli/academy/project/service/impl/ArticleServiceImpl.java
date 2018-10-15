package com.blibli.academy.project.service.impl;

import com.blibli.academy.project.Business.dto.ArticleDetaDto;
import com.blibli.academy.project.Business.dto.BannerDto;
import com.blibli.academy.project.Business.dto.HomeArticleDto;
import com.blibli.academy.project.Business.dto.HomeBannerDto;
import com.blibli.academy.project.codeconst.FindNull;
import com.blibli.academy.project.codeconst.RessNull;
import com.blibli.academy.project.mapper.StudentDao;
import com.blibli.academy.project.query.PageQuery;
import com.blibli.academy.project.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-25 14:56
 */
@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
    @Resource
    StudentDao studentDao;
    //card文章列表
    @Override
    public PageInfo<HomeArticleDto> findArticle(PageQuery pageQuery) throws FindNull {
        PageHelper.startPage(pageQuery.getPageNum(),pageQuery.getPageSize());
        List<HomeArticleDto> homeArticleDtos = studentDao.findArticelList();
        log.debug("studentDao" +studentDao.findArticelList());
        if (homeArticleDtos.isEmpty()){
            throw new FindNull("card文章无数据");
        }
        for (HomeArticleDto homeArticleDto : homeArticleDtos){
            homeArticleDto.setLoveStu(studentDao.findLoveStatus(homeArticleDto.getId(),pageQuery.getUserId(),1));
            homeArticleDto.setCollectionStu(studentDao.findLoveStatus(homeArticleDto.getId(),pageQuery.getUserId(),2));
            log.debug("状态为"+ homeArticleDto);
        }
        PageInfo<HomeArticleDto> bean = new PageInfo<>(homeArticleDtos);
        bean.setList(homeArticleDtos);
        log.debug("页面信息" + bean);
        return bean;
    }

    @Override
    public ArticleDetaDto findByid(Long id, Long stu) throws RessNull {
        ArticleDetaDto articleDetaDto = studentDao.findCardByid(id,stu);
        if (articleDetaDto == null ){
            throw new RessNull("该文章不存在或已下架");
        }
        return articleDetaDto;
    }

    @Override
    public Boolean updateLoveStatus(Long studyId, Long userId, Integer type) {
        log.debug("传入的参数是:" + studyId + userId + type);
        //判断是否点赞过,有点赞删除点赞记录
        if (studentDao.findLoveStatus(studyId, userId, type)) {
            studentDao.deleteLoveStatus(studyId, userId, type);
            return false;
        }
        try {
            return studentDao.insertLoveStatus(studyId, userId, type, new Date());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("点赞收藏失败，用户或文章id不存");
        }
    }

    @Override
    public List<BannerDto> findArticleBanner(Integer num) throws FindNull,RessNull {
        List<BannerDto> bannerDtos = studentDao.findArticleBanner(num);
        if (bannerDtos.isEmpty()){
            throw new FindNull("无banner文章数据");
        }
        return bannerDtos;
    }
}

