package com.blibli.academy.project.controller;

import com.blibli.academy.project.codeconst.ResponseVO;
import com.blibli.academy.project.codeconst.RessNull;
import com.blibli.academy.project.service.WechatService;
import com.blibli.academy.project.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-21 09:58
 */
@Slf4j
@Api(tags = "WeixController", description = "微信相关Api")
@RestController
@RequestMapping("/a/user")
@Validated
public class WeixController {
    @Autowired
    WechatService wechatService;

    @ApiOperation(value = "微信登陆", notes = "获取用户code值登陆")
    @GetMapping("/{code}")
    public ResponseVO mychatAccredit(@PathVariable String code) throws RessNull {
        log.info(code);
        return ResultUtil.success("微信登陆成功", wechatService.userLogin(code));
    }

    @ApiOperation(value = "获取微信接口权限", notes = "传入访问JS_SDK接口的url")
    @PostMapping("/authority")
    public ResponseVO muchatAuthority(@RequestBody String url) throws RessNull {
        // 注意 URL 一定要动态获取，不能 hardcode(硬编码), 签名用的url必须是调用JS接口页面的完整URL。
        return ResultUtil.success("微信接口权限令牌获取成功：", wechatService.weChatAuthority(url));
    }

}
