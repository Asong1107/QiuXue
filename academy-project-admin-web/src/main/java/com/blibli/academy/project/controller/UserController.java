package com.blibli.academy.project.controller;

import com.blibli.academy.project.Business.dto.UserListDto;
import com.blibli.academy.project.codeconst.ResponseRowsVO;
import com.blibli.academy.project.codeconst.ResponseVO;
import com.blibli.academy.project.query.UserQuery;
import com.blibli.academy.project.service.HomeUserService;
import com.blibli.academy.project.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.expression.ParseException;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-24 19:14
 */
@RestController
@Slf4j
@Validated
public class UserController {

    @Autowired
    HomeUserService homeUserService;


    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @RequiresPermissions(".user")
    @PostMapping("/root/users")
    public ResponseRowsVO findUserlist(@Valid @RequestBody UserQuery userQuery) throws ParseException, UnsupportedEncodingException, Exception {
        PageInfo<UserListDto> pageInfo = homeUserService.findUser(userQuery);
        if (pageInfo.getTotal() !=0){
            return ResultUtil.success("获取用户收藏列表",pageInfo);
        }else {
            return ResultUtil.error("获取用户列表失败",null);
        }
    }

    @ApiOperation(value = "改变用户状态", notes = "根据ID改变用户状态")
    @RequiresPermissions(".user")
    @PutMapping("/root/status/{id}")
    public ResponseVO UpdateStatus(@Min(value = 0, message = "不小于0") @PathVariable("id") Long id) throws Exception {
        return ResultUtil.success("用户冻结解冻状态,", homeUserService.updateStatus(id));
    }


    @ApiOperation(value = "获取用户详情", notes = "根据ID获取用户详情")
    @RequiresPermissions(".user")
    @GetMapping("/root/user/{id}")
    public ResponseVO getUserId(@Min(value = 0, message = "不小于0") @PathVariable("id") Long id) throws Exception {
        return ResultUtil.success("获取用户详情", homeUserService.findUserByid(id));
    }
}