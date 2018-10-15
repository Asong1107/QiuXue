package com.blibli.academy.project.controller;


import com.blibli.academy.project.Business.pojo.Module;
import com.blibli.academy.project.Business.pojo.Role;
import com.blibli.academy.project.codeconst.ResponseRowsVO;
import com.blibli.academy.project.codeconst.ResponseVO;
import com.blibli.academy.project.service.UserServiceLast;
import com.blibli.academy.project.tools.LoginName;
import com.blibli.academy.project.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 *
 * @author baich
 */
@Api(tags = "ServiceListController",description = "角色和模块儿")
@RestController
@Slf4j
public class ServiceListController {

    @Autowired
    UserServiceLast userServiceLast;

    @Autowired
    LoginName loginName;



    /**
     * 角色列表------已测
     * @return
     */
    @ApiOperation(value = "角色列表",notes = "role")
    @RequiresPermissions(".role")
    @GetMapping(value = "root/role/list")
    public ResponseRowsVO findRoleList(){
        try {
            List<Role> role = userServiceLast.findRoleList();
            return ResultUtil.success("获取角色列表成功",role);
        }catch (Exception e){
            return ResultUtil.error("查询列表错误",null);
        }
    }

    /**
     * 角色编辑------------第二次 已测试
     * 角色编辑时 当就权限 为4个，新权限为3个时无法更新，所以先删除roleModule的角色权限 在添加。
     */
    @ApiOperation(value = "角色权限的查看",notes = "rolename")
    @RequiresPermissions(".role")
    @GetMapping("root/role/e/{roleId}")
    public ResponseRowsVO findRoleName(@PathVariable Long roleId){
        try{
            List<Role> rolename= userServiceLast.findRoleData(roleId);
            return ResultUtil.success("当前角色数据",rolename);
        }catch (Exception e){
            return ResultUtil.error("获取角色失败" +e,null);
        }
    }


    @ApiOperation(value = "角色编辑",notes = "返回状态码")
    @RequiresPermissions(".role")
    @PutMapping("root/role/e")
    public ResponseVO updateRoleId(@RequestBody Role role){

        return userServiceLast.insertRoleModule(role);
    }


    /**
     * 删除 角色-----已测
     */
    @ApiOperation(value = "删除角色",notes = "返回状态码")
    @RequiresPermissions(".role")
    @DeleteMapping("root/role/d/{roleId}")
    public ResponseVO deleteRole(@PathVariable Long roleId){
        try{
            Boolean count = userServiceLast.deleteRole(roleId);
            userServiceLast.deleteRoleModuleId(roleId);
         return ResultUtil.success("角色删除成功",count);
        }catch (Exception e){
          return ResultUtil.error("删除数据错误");
        }
    }




    /**
     * 角色新增-------第二次已测试
     * 前端传递角色数组 ，后端for 遍历 数组insert到数据库。
     */
    @ApiOperation(value = "角色的新增",notes = "返回状态码")
    @RequiresPermissions(".role")
    @PostMapping("root/role/a")
    public ResponseVO insertRole(@RequestBody Role role) {

        return userServiceLast.insertRole(role);
    }




    /**
     *所有模块儿列表-----------已测
     */
    @ApiOperation(value = "模块儿列表",notes = "module")
    @RequiresPermissions(".module")
    @GetMapping("root/module/list")
    public ResponseRowsVO findModuleList(){
        try{
            List<Module> module = userServiceLast.findModuleList();
            return ResultUtil.success("模块儿列表",module);
        }catch (Exception e){
            return ResultUtil.error("查询数据出错",null);
        }

    }




    /**
     *模块儿详情----------已测
     */
    @ApiOperation(value = "模块儿的详情",notes = "module")
    @RequiresPermissions(".module")
    @GetMapping("root/module/e/{id}")
    public ResponseVO findModuleId(@PathVariable Long id){
        try {
            Module module = userServiceLast.findModuleId(id);
            return ResultUtil.success("模块儿详情",module);
        }catch (Exception e){
            return ResultUtil.error("数据查询失败");
        }
    }

    /**
     *模块儿更新-------
     */
    @ApiOperation(value = "模块儿的更新",notes = "返回状态码")
    @RequiresPermissions(".module")
    @PutMapping("root/module/e")
    public ResponseVO updateModule(@RequestBody Module module)  {
        return userServiceLast.updateModule(module);
    }

    /**
     *模块儿添加
     */
    @ApiOperation(value = "增加模块儿",notes = "返回状态码")
    @RequiresPermissions(".module")
    @PostMapping("root/module/a")
    public ResponseVO insertModule(@RequestBody Module module) {
        return userServiceLast.insertModule(module);
    }

    /**
     *模块儿删除
     */
    @ApiOperation(value = "删除某个模块儿",notes = "返回状态码")
    @RequiresPermissions(".module")
    @DeleteMapping("root/module/{id}")
    public ResponseVO deleteModuleId(@PathVariable Long id){
        try {
            Boolean count = userServiceLast.deleteModuleId(id);
            return ResultUtil.success("删除数据成功",count);
        }catch (Exception e){
            return ResultUtil.error("删除数据出错");
        }
    }


}
