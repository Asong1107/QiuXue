package com.blibli.academy.project.mapper;

import com.blibli.academy.project.Business.dto.UserListDto;
import com.blibli.academy.project.Business.pojo.User;
import com.blibli.academy.project.mapperplus.BaseMapper;
import com.blibli.academy.project.query.UserQuery;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-19 01:24
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    //查询用户列表信息
    List<UserListDto> findUserList(UserQuery userQuery);

    @Select("SELECT * FROM user WHERE id = #{id}")
    User findUserById(@Param("id") Long id);

    @Update("UPDATE user u SET u.status = !u.status, u.update_at = #{update_at}, u.update_by = #{update_by}  WHERE u.id = #{id}")
    Integer updateStatus(@Param("id") Long id, @Param("update_at")Date update_at,@Param("update_by") String update_by);


}
