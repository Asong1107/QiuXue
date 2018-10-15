package com.blibli.academy.project.service.impl;

import com.blibli.academy.project.Business.dto.StudentDto;
import com.blibli.academy.project.Business.enumerate.ClassifyEnum;
import com.blibli.academy.project.Business.enumerate.GradeEnum;
import com.blibli.academy.project.Business.enumerate.SubjectEnum;
import com.blibli.academy.project.Business.pojo.Student;
import com.blibli.academy.project.codeconst.RessNull;
import com.blibli.academy.project.dto.ArticleDto;
import com.blibli.academy.project.dto.ArticleListDto;
import com.blibli.academy.project.dto.VideoListDto;
import com.blibli.academy.project.mapper.StudentDao;
import com.blibli.academy.project.query.StudentQuery;
import com.blibli.academy.project.service.*;
import com.blibli.academy.project.tools.LoginName;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-18 17:51
 */
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentDao studentDao;
    @Resource
    ConService conService;
    @Resource
    ConsService consService;
    @Resource
    private QiniuService qiniuService;
    @Resource
    private LoginName loginName;
    @Resource
    private HomeUserService homeUserService;

    @Override
    public PageInfo<?> findPageBreakByCondition(Object objectQuery) throws Exception {
        StudentQuery studentQuery = new StudentQuery();
        BeanUtils.copyProperties(objectQuery,studentQuery);
        PageHelper.startPage(studentQuery.getPageNum(),studentQuery.getPageSize());
        List<StudentDto> studentDtoList = studentDao.findPageBreakByCondition(studentQuery);
        log.debug("studentDao" + studentDao.findPageBreakByCondition(studentQuery));
        PageInfo bean = new PageInfo<StudentDto>(studentDtoList);
        //判断是否查询到数据
        if (studentQuery.getStudy_type() == 1){
            List<ArticleListDto> articleListDtos = new ArrayList<>();
            for (StudentDto s : studentDtoList){
                ArticleListDto articleListDto = new ArticleListDto();
                BeanUtils.copyProperties(s,articleListDto);
                log.debug("文章查询结果"+articleListDto.toString());
                try {
                    articleListDto.setClassify(ClassifyEnum.getArticleEnum(s.getClassify()).getName());
                }catch (Exception e){
                    log.debug("有空Enum值");
                    e.printStackTrace();
                }
                articleListDtos.add(articleListDto);
            }
            PageInfo pageInfo = new PageInfo<ArticleListDto>(articleListDtos);
            BeanUtils.copyProperties(bean,pageInfo);
            pageInfo.setList(articleListDtos);
            return pageInfo;
        }
        List<VideoListDto> videoListDtos = new ArrayList<>();
        for (StudentDto s:studentDtoList){
            VideoListDto videoListDto = new VideoListDto();
            BeanUtils.copyProperties(s,videoListDto);
            log.debug("视频查询结果" + videoListDto.toString());
            try {
                videoListDto.setClassify(ClassifyEnum.getArticleEnum(s.getClassify()).getName());
                videoListDto.setSubject(SubjectEnum.getSubjectEnum(s.getSubject()).getSubject());
                videoListDto.setGrade(GradeEnum.getGradEnum(s.getGrade()).getGrade());
            }catch (Exception e){
                log.debug("有空enum值");
                e.printStackTrace();
            }
            videoListDtos.add(videoListDto);
        }
        PageInfo pageInfo = new PageInfo<VideoListDto>(videoListDtos);
        BeanUtils.copyProperties(bean,pageInfo);
        pageInfo.setList(videoListDtos);
        return pageInfo;
    }

    @Override
    public Boolean updateStatusByid(Long id) throws Exception{
        if (!studentDao.updateStatusByid(id)){
            throw new RessNull("更新失败");
        }
        return true;
    }


    @Override
    public Long insertArticle(ArticleDto articleDto) throws Exception {
        if (!"".equals(articleDto.getCovering()) && articleDto.getCovering() !=null){
            articleDto.setCovering(qiniuService.updateFile(articleDto.getCovering()));
        }
        Student student = new Student();
        BeanUtils.copyProperties(articleDto,student);
        student.setStudy_type(1);
        student.setCreateAt(new Date());
        student.setUpdate_at(new Date());
        student.setCreate_by(loginName.loginName());
        student.setUpdate_by(loginName.loginName());
        studentDao.insert(student);
        return student.getId();
    }

    @Override
    public ArticleDto findArticleById(Long id) throws Exception {
        Student student = studentDao.selectByPrimaryKey(id);
        ArticleDto articleDto = new ArticleDto();
        BeanUtils.copyProperties(student,articleDto);
        return articleDto;
    }

    @Override
    public Boolean updateArticle(ArticleDto articleDto) throws Exception {
        log.info("articleDto.toString(): " + articleDto.toString());
        if (!"".equals(articleDto.getCovering()) && articleDto.getCovering() !=null){
            articleDto.setCovering(qiniuService.updateFile(articleDto.getCovering()));
        }
        Student student = new Student();
        BeanUtils.copyProperties(articleDto,student);
        student.setStudy_type(1);
        student.setUpdate_at(new Date());
        student.setUpdate_by(loginName.loginName());
        log.debug("studentDao"+studentDao);
        return studentDao.updateByPrimaryKeySelective(student) > 0;
    }

    @Override
    public StudentDto insert(StudentDto entity) throws Exception {
        if(!"".equals(entity.getCovering()) && entity.getCovering() !=null){
            //将文件上传到七牛-------返回七牛的下载链接
            entity.setCovering(qiniuService.updateFile(entity.getCovering()));
        }
        Student student = new Student();
        BeanUtils.copyProperties(entity,student);
        student.setCreateAt(new Date());
        student.setUpdate_at(new Date());
        student.setCreate_by(loginName.loginName());
        student.setUpdate_by(loginName.loginName());
        studentDao.insert(student);
        log.debug("studentDto.insert" + student.toString());
        return entity;
    }

    @Override
    public void insertList(List<StudentDto> entities) {

    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean update(StudentDto entity) throws FileNotFoundException {
        return false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(StudentDto entity) throws Exception {
        log.debug("entity.toString()更新信息:" + entity.toString());
        if(!"".equals(entity.getCovering()) && entity.getCovering() !=null){
            //将文件上传到七牛-------返回七牛的下载链接
            entity.setCovering(qiniuService.updateFile(entity.getCovering()));
        }
        Student student = new Student();
        BeanUtils.copyProperties(entity,student);
        student.setCreate_by(loginName.loginName());
        student.setUpdate_by(loginName.loginName());
        student.setStudy_type(1);
        return studentDao.updateByPrimaryKeySelective(student) > 0;
    }

    @Override
    public StudentDto getByPrimaryKey(Long primaryKey) {
        return null;
    }

    @Override
    public StudentDto getOneByEntity(StudentDto entity) {
        return null;
    }

    @Override
    public List<StudentDto> listAll() {
        return null;
    }

    @Override
    public List<StudentDto> listByEntity(StudentDto entity) {
        return null;
    }
}
