package com.blibli.academy.project.service;

import com.blibli.academy.project.Business.dto.HomeVideDto;
import com.blibli.academy.project.Business.dto.SigningDto;
import com.blibli.academy.project.Business.dto.StudentBindingDto;
import com.blibli.academy.project.Business.dto.StuentCardDto;
import com.blibli.academy.project.Business.pojo.Student;
import com.blibli.academy.project.Business.pojo.Video;
import com.blibli.academy.project.businsess.Dto.StudentDto;
import com.blibli.academy.project.codeconst.RessNull;
import com.github.pagehelper.PageInfo;

/**
 * 学生证相关接口
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-20 15:32
 */
public interface StudentService {
    //根据id获取用户详情
    StuentCardDto selectAll(Long id) throws RessNull;

    //用户绑定信息
    StudentBindingDto selectBinding(Long id) throws RessNull;

    //更新用户信息
    String updateStudent(StudentDto studentDto) throws RessNull;

    //获取用户收藏文章
    PageInfo findCollectArticle(Long id, Integer pageNum) throws RessNull;

    //获取用户收藏视频
    PageInfo<Video> findCollectVideo(Long userId, Integer pageNum) throws RessNull;

    //验证邮箱
    SigningDto updateEmail(Long id, String code) throws RessNull;
    //手机验证
    SigningDto updatePhone(Long id,String phone)throws RessNull;

}
