package com.blibli.academy.project.service;

import com.blibli.academy.project.Business.dto.StudentDto;
import com.blibli.academy.project.dto.ArticleDto;
import com.blibli.academy.project.mapper.BaseService;
import com.github.pagehelper.PageInfo;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-18 17:51
 */
public interface StudentService extends BaseService<StudentDto,Long> {
    //获取文章后台集合
    PageInfo<?> findPageBreakByCondition(Object objectQuery)throws Exception;
    //更改文章状态
    Boolean updateStatusByid(Long id)throws Exception;
    //创建文章
    Long insertArticle(ArticleDto articleDto) throws Exception;
    //根据id查询数据
    ArticleDto findArticleById(Long id)throws Exception;
    //更新文章
    Boolean updateArticle(ArticleDto articleDto)throws Exception;
}
