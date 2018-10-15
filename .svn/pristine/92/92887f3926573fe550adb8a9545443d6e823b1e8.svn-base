package com.blibli.academy.project.service.impl;



import com.blibli.academy.project.codeconst.ResponseVO;
import com.blibli.academy.project.pojo.UserServiceQuery;
import com.blibli.academy.project.mapper.UserDao;
import com.blibli.academy.project.Business.pojo.Module;
import com.blibli.academy.project.Business.pojo.UserService;
import com.blibli.academy.project.service.UserServices;
import com.blibli.academy.project.tools.LoginName;
import com.blibli.academy.project.tools.PassEncrypt;
import com.blibli.academy.project.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author baich
 */

@Service
@Slf4j
public class UserServicesImpl implements UserServices {

@Autowired
UserDao userDao;

@Resource
  private LoginName login;

    /**
     *根据姓名查找 后台管理人员的数据------登陆验证用的
     */
    @Override
    public UserService findUsername(String username){
        return userDao.findUsername(username);
    }

    /**
     * 用户登陆成功 展示首页 ------将 管理员拥有的权限模块儿 传递过去。
     * 用了两个接口
     * @param username
     * @return
     */
    @Override
    public Long findUserId(String username){
        return userDao.findUserId(username);
    }

    @Override
    public List<Module> findUserModule(Long id){
        return userDao.findUserModule(id);
    }


    /**
     * 获取 管理员账号列表
     * @return
     */
    @Override
    public PageInfo<UserService> getUserList( UserServiceQuery userServiceQuery) {

        PageHelper.startPage(userServiceQuery.getPageNum(), userServiceQuery.getPageSize());
        List<UserService> getUserList = userDao.getUserList(userServiceQuery);
        System.out.println("查看获取的数据------"+getUserList);
        return new PageInfo<>(getUserList);
    }

    /**
     * 管理员账号新增
     * @param userService
     */

    @Override
    public ResponseVO insertAdmin(UserService userService){
        if(userService.getSecondPwd().equals(userService.getPassword())) {
            try {
                //密码调用 shiro工具类 加密
                String password = PassEncrypt.PasswordEncrypt(userService.getUsername(),userService.getPassword());
                // 数据库插入数据
                userService.setPassword(password);
                userService.setStatus(1);
                userService.setCreateBy(login.loginName());
                userService.setUpdateBy(login.loginName());
                userService.setCreateAt(login.newDate());
                userService.setUpdateAt(login.newDate());
                System.out.println("输出结果"+ userService);
                //调用接口插入
                userDao.insertAdmin(userService);
                return ResultUtil.success("新增账号成功");
            }catch (Exception e){
                return ResultUtil.error("新增数据失败");
            }
        }else {
            return ResultUtil.error("两次密码输入不相同");
        }
    }

    /**
     * 管理员账号信息修改
     */
    @Override
    public UserService findAdminId(Long id){
        return userDao.findAdminId(id);
    }

    @Override
    public ResponseVO updateAdmin(UserService userService){

        if(userService.getSecondPwd().equals(userService.getPassword())){
            try{
                //密码调用 shiro工具类 加密
                String password = com.blibli.academy.project.tools.PassEncrypt.PasswordEncrypt(userService.getUsername(), userService.getPassword());
                userService.setPassword(password);
                userService.setUpdateBy(login.loginName());
                userService.setUpdateAt(login.newDate());

                userDao.updateAdmin(userService);
                return ResultUtil.success("更新数据成功");
            }catch (Exception e){
                return ResultUtil.error("代码执行出错"); }
        }else{
            return ResultUtil.error("两次输入的密码不相同");

        }
    }


    /**
     *删除管理员账号
     */
    @Override
    public  Boolean deleteAdmin(Long id){
        return  userDao.deleteAdmin(id);
    }

    /**
     * 修改密码
     */
    @Override
    public ResponseVO updatePassword(UserService userService){
        String upPwd = PassEncrypt.PasswordEncrypt(login.loginName(),userService.getUpPwd());
        String password = PassEncrypt.PasswordEncrypt(login.loginName(),userService.getPassword());

        //调用 根据用户名 获取 当前用户数据，----userservice.getPassword()获取数据库密码
        UserService userservice = userDao.findUsername(login.loginName());
        if(userservice.getPassword().equals(upPwd)){
            log.info("----------旧密码正确----------");
            if(userService.getPassword().equals(userService.getSecondPwd())){
                log.info("------------两次新密码 检验正确-------------");
                try {
                    UserService userService1= new UserService();
                    userService1.setPassword(password);
                    userService1.setUsername(login.loginName());
                    log.info("新密码显示-------"+ password);
                    userDao.updatePassword(userService1);
                    return ResultUtil.success("更改密码成功");
                }catch (Exception e){
                    return ResultUtil.error("更改密码出错"); }
            }else {
                return ResultUtil.error("两次密码不相同");
            }
        }else{
            return ResultUtil.error("旧密码输入不正确");
        }
    }
}
