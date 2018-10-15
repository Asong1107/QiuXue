package com.blibli.academy.project.service;

import com.blibli.academy.project.Business.dto.TecherDto;
import com.blibli.academy.project.Business.dto.UserDto;
import com.blibli.academy.project.Business.dto.UserListDto;
import com.blibli.academy.project.Business.pojo.Student;
import com.blibli.academy.project.mapper.BaseService;
import com.blibli.academy.project.query.UserQuery;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-24 19:23
 */
public interface HomeUserService extends BaseService<TecherDto,Long> {
    //用户列表
    PageInfo<UserListDto> findUser(UserQuery userQuery) throws Exception;

    //更新用户状态
    Integer updateStatus(Long id) throws Exception;

    UserDto findUserByid(Long id) throws Exception;

    /**
     * 获取指定分类的名称
     * @param name
     * @return
     * @throws Exception
     */
    List<Object> findListByName(String name) throws Exception;

    Long updateTehcer(Student student);

}