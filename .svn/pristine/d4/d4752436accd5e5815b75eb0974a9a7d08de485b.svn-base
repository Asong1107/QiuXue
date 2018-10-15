package com.blibli.academy.project.controller;


import com.blibli.academy.project.Business.pojo.Module;
import com.blibli.academy.project.Business.pojo.UserService;
import com.blibli.academy.project.codeconst.ResponseRowsVO;
import com.blibli.academy.project.pojo.UserServiceQuery;
import com.blibli.academy.project.codeconst.ResponseVO;
import com.blibli.academy.project.service.UserServices;
import com.blibli.academy.project.tools.LoginName;
import com.blibli.academy.project.tools.PassEncrypt;
import com.blibli.academy.project.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * 登陆验证和首页的Controller
 * @author baich
 */
@Api(tags = "AdminController", description = "账号管理")
@RestController
@Slf4j
public class AdminController {
    @Autowired
    private UserServices userServices;

    @Autowired
    private LoginName loginName;



    /**
     * 登录请求接口方式登陆--------已测试
     */
    @ApiOperation(value = "shiro的拦截登陆",notes = "返回登陆状态")
    @PostMapping(value="/login")
    public ResponseVO submitLogin(@RequestBody UserService userService) {
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(userService.getUsername(), userService.getPassword());
            SecurityUtils.getSubject().login(token);
            SecurityUtils.getSubject().getSession().setTimeout(18000000);
        return ResultUtil.success("登陆成功",userServices.findUsername(userService.getUsername()));
        } catch (Exception e) {
          return ResultUtil.error("账号或密码错误");
        }
    }

    /**
     * 登陆成功跳转的页面
     * @return
     */
    @GetMapping("/success")
    public ResponseVO loginSuccess(){ return ResultUtil.success("登陆成功"); }

    @GetMapping("/error")
    public ResponseVO loginError(){ return ResultUtil.error("您无权访问该接口"); }

    /**
     * 用户账号退出-----已测试
     * @return
     */
    @ApiOperation(value = "账号退出",notes = "状态码")
    @GetMapping("/logout")
    public ResponseVO userLogout(){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
     return ResultUtil.success("退出成功");
    }


/**
 * 加载首页面---------- 从首页把模块儿传给他们。-----已测试
 */

    @ApiOperation(value = "用户模块儿展示",notes = "模块儿列表")
    @RequiresPermissions(".account")
    @GetMapping("module/list/index")
    public ResponseRowsVO index(){
        log.info("进入到这里了吗-------");
            //从凭证中获得用户名-------获取用户名取决于你在realm中存入了 什么 存对象就取对象，存字符串就取字符串。
            Long id = userServices.findUserId(loginName.loginName());
            log.info("获取用户 ID ---" + id);

            List<Module> module =  userServices.findUserModule(id);
            log.info("获取用户模块儿数据----"+module);
            return ResultUtil.success("获取成功",module);
    }


    /**
     *  后台管理-------------账号管理列表----已测
     */
    @ApiOperation(value = "账号管理列表",notes = "反回分页数据")
    @RequiresPermissions(".account")
    @PostMapping(value = "root/admin/list")

    public ResponseRowsVO getUserList(@ModelAttribute UserServiceQuery userServiceQuery){
       return ResultUtil.success("账号管理列表获取成功",userServices.getUserList(userServiceQuery));
    }


    /**
     * 新增管理员账号------以测试
     *	"username":"root",
     * 	"password":"root",
     * 	"secondPwd":"root",
     * 	"phone":12345678901,
     * 	"status":1,
     * 	"roleId":2
     */
    @ApiOperation(value = "新增管理员账号",notes = "返回状态码")
    @RequiresPermissions(".account")
    @PostMapping(value = "root/admin/a")
    public ResponseVO adminInsert(@RequestBody UserService userService)  {
       return userServices.insertAdmin(userService);
    }


    /**
     * 更新账号------已测试
     */
    @ApiOperation(value = "更新管理员账号",notes = "首先是查出这个账号的数据")
    @RequiresPermissions(".account")
    @GetMapping(value="root/admin/e/{id}")
    public ResponseVO findAdminId(@PathVariable Long id) {
        try {
            return ResultUtil.success("获取数据成功", userServices.findAdminId(id));
        } catch (Exception e) {
            return ResultUtil.error("获取账号信息错误");
        }
    }

    @ApiOperation(value = "更新管理员账号",notes = "返回更新状态码")
    @RequiresPermissions(".account")
    @PostMapping(value = "root/admin/e/")
    public ResponseVO adminUpdate(@RequestBody UserService userService){

        return userServices.updateAdmin(userService);
    }


    /**
     *删除账号------ 已测试
     */
    @ApiOperation(value = "删除管理员账号",notes = "返回状态码")
    @RequiresPermissions(".account")
    @DeleteMapping(value = "root/admin/{id}")
    public ResponseVO adminDelete(@PathVariable Long id){
        try {
            Boolean count = userServices.deleteAdmin(id);
            if(count){
             return ResultUtil.success("删除成功");
            }else {
              return ResultUtil.error("没有此ID"); }
        }catch (Exception e){
         return ResultUtil.error("错误");
        }
    }


    /**
     * 修改密码------已测试
     */
    @ApiOperation(value = "修改账号的密码",notes = "返回状态码")
    @RequiresPermissions(".password")
    @PostMapping(value = "root/admin/pwd/e")
    public ResponseVO passwordUpdate(@RequestBody UserService userService) {

        return userServices.updatePassword(userService);
    }
}
