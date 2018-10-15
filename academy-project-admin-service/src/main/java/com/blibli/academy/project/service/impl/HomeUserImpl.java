package com.blibli.academy.project.service.impl;

import com.blibli.academy.project.Business.dto.TecherDto;
import com.blibli.academy.project.Business.dto.UserDto;
import com.blibli.academy.project.Business.dto.UserListDto;
import com.blibli.academy.project.Business.enumerate.ClassifyEnum;
import com.blibli.academy.project.Business.enumerate.GradeEnum;
import com.blibli.academy.project.Business.enumerate.SubjectEnum;
import com.blibli.academy.project.Business.pojo.Student;
import com.blibli.academy.project.Business.pojo.User;
import com.blibli.academy.project.codeconst.RessNull;
import com.blibli.academy.project.dto.ClassifyDto;
import com.blibli.academy.project.mapper.StudentDao;
import com.blibli.academy.project.mapper.TeacherDao;
import com.blibli.academy.project.mapper.UserMapper;
import com.blibli.academy.project.query.UserQuery;
import com.blibli.academy.project.service.ConService;
import com.blibli.academy.project.service.HomeUserService;
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
 * @create: 2018-08-24 19:25
 */
@Slf4j
@Service
public class HomeUserImpl implements HomeUserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private ConService conService;
    @Resource
    private LoginName loginName;
    @Resource
    private TeacherDao teacherDao;
    @Resource
    private StudentDao studentDao;
    @Override
    public PageInfo<UserListDto> findUser(UserQuery userQuery) throws Exception{
        log.debug("查询用户的列表传入的参数");
        PageHelper.startPage(userQuery.getPageNum(),userQuery.getPageSize());
        List<UserListDto> userListDtos = userMapper.findUserList(userQuery);
//        if (userListDtos.isEmpty()){
//            throw new FindNull("搜索不到用户信息");
//        }
        return new PageInfo<>(userListDtos);
    }

    @Override
    public List<Object> findListByName(String name) throws Exception {
        List<Object> classify = new ArrayList<Object>();
        if ("article".equals(name)) {
            for (ClassifyEnum article :
                    ClassifyEnum.values()) {
                ClassifyDto classifyDto = new ClassifyDto();
                classifyDto.setId(article.getCode());
                classifyDto.setName(article.getName());
                classify.add(classifyDto);
            }
        }
        if ("grade".equals(name)) {
            for (GradeEnum gradeEnum :
                    GradeEnum.values()) {
                ClassifyDto classifyDto = new ClassifyDto();
                classifyDto.setId(gradeEnum.getCode());
                classifyDto.setName(gradeEnum.getGrade());
                classify.add(classifyDto);
            }
        }
        if ("subject".equals(name)) {
            for (SubjectEnum subjectEnum :
                    SubjectEnum.values()) {
                ClassifyDto classifyDto = new ClassifyDto();
                classifyDto.setId(subjectEnum.getCode());
                classifyDto.setName(subjectEnum.getSubject());
                classify.add(classifyDto);
            }
        }
        return classify;
    }


    @Override
    public Long updateTehcer(Student student) {
        return null;
    }



    @Override
    public Integer updateStatus(Long id) throws Exception {
        Integer integer = userMapper.updateStatus(id,new Date(),loginName.loginName());
        if (integer == 0){
            throw new RessNull("用户不存在或修改失败");
        }
        return integer;
    }

    @Override
    public UserDto findUserByid(Long id) throws Exception {
        User user = userMapper.selectByPrimaryKey(id);
        if (user == null){
            throw new RessNull("用户不存在");
        }
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user,userDto);
        return userDto;
    }

    @Override
    public TecherDto insert(TecherDto entity) throws Exception {
        return null;
    }

    @Override
    public void insertList(List<TecherDto> entities) {

    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean update(TecherDto entity) throws FileNotFoundException {
        return false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(TecherDto entity) throws FileNotFoundException, Exception {
        return false;
    }

    @Override
    public TecherDto getByPrimaryKey(Long primaryKey) {
        return null;
    }

    @Override
    public TecherDto getOneByEntity(TecherDto entity) {
        return null;
    }

    @Override
    public List<TecherDto> listAll() {
        return null;
    }

    @Override
    public List<TecherDto> listByEntity(TecherDto entity) {
        return null;
    }
}
