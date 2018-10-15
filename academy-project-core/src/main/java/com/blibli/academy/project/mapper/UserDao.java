package com.blibli.academy.project.mapper;


import com.blibli.academy.project.Business.pojo.Module;
import com.blibli.academy.project.Business.pojo.UserService;
import com.blibli.academy.project.pojo.UserServiceQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author baich
 */
@Repository
public interface UserDao {



    /**
     *根据姓名查找 后台管理人员的数据------根据登陆的用户名取对应的密码
     */
    UserService findUsername(String username);

    /**
     * 用户登陆成功 展示首页 ------将 管理员拥有的权限模块儿 传递过去。
     * 用了两个接口
     * @param username
     * @return
     */
    Long findUserId(String username);

    List<Module> findUserModule(Long id);

    /**
     * 获取账号列表
     */
    List<UserService> getUserList(UserServiceQuery userServiceQuery);

    /**
     * 管理员账号新增
     * @param userService
     */

    void insertAdmin(UserService userService);

    /**
     * 管理员账号信息修改
     */
    UserService findAdminId(Long id);

    void updateAdmin(UserService userService);

    /**
     *删除管理员账号
     */

    Boolean deleteAdmin(Long id);

    /**
     * 修改密码
     */
    void updatePassword(UserService userService1);


}
