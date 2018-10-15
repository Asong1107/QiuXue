package com.blibli.academy.project.service;


import com.blibli.academy.project.Business.pojo.Module;
import com.blibli.academy.project.Business.pojo.User;
import com.blibli.academy.project.codeconst.ResponseVO;
import com.blibli.academy.project.pojo.UserServiceQuery;
import com.github.pagehelper.PageInfo;
import com.blibli.academy.project.Business.pojo.UserService;
import java.util.List;

/**
 * @author baich
 */
public interface UserServices {

    /**
     *根据姓名查找 后台管理人员的数据------登陆验证用的
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
     * 获取 管理员账号列表
     * @return
     */
    PageInfo<UserService> getUserList (UserServiceQuery userServiceQuery);

    /**
     * 管理员账号新增
     * @param userService
     */
    ResponseVO insertAdmin(UserService userService);

    /**
     * 管理员账号信息修改
     */
    UserService findAdminId(Long id);

    ResponseVO updateAdmin(UserService userService);

    /**
     *删除管理员账号
     */

    Boolean deleteAdmin(Long id);
    /**
     * 修改密码
     */
    ResponseVO updatePassword(UserService userService1);


}
