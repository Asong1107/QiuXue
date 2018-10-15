package com.blibli.academy.project.service.impl;

import com.blibli.academy.project.Business.pojo.Teacher;
import com.blibli.academy.project.dto.ArticleAuthorDto;
import com.blibli.academy.project.mapper.TeacherDao;
import com.blibli.academy.project.service.ConsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-18 21:54
 */

@Service
@Slf4j
public class ConsServiceImpl implements ConsService {
    @Autowired
    TeacherDao teacherDao;



    @Override
    public ArticleAuthorDto insert(ArticleAuthorDto entity) throws Exception {
        return null;
    }

    @Override
    public void insertList(List<ArticleAuthorDto> entities) {

    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean update(ArticleAuthorDto entity) throws FileNotFoundException {
        return false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ArticleAuthorDto entity) throws FileNotFoundException, Exception {
        return false;
    }

    @Override
    public ArticleAuthorDto getByPrimaryKey(Long primaryKey) {
        return null;
    }

    @Override
    public ArticleAuthorDto getOneByEntity(ArticleAuthorDto entity) {
        return null;
    }

    @Override
    public List<ArticleAuthorDto> listAll() {
        return null;
    }

    @Override
    public List<ArticleAuthorDto> listByEntity(ArticleAuthorDto entity) {
        return null;
    }

    @Override
    public Long findAuthorByName(String name) throws Exception {
        return null;
    }
}
