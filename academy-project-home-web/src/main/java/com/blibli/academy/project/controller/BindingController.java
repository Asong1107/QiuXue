package com.blibli.academy.project.controller;

import com.aliyuncs.exceptions.ClientException;
import com.blibli.academy.project.Business.dto.SigningDto;
import com.blibli.academy.project.codeconst.ResponseVO;
import com.blibli.academy.project.codeconst.RessNull;
import com.blibli.academy.project.service.SMSService;
import com.blibli.academy.project.service.StudentService;
import com.blibli.academy.project.util.EmailUtil;
import com.blibli.academy.project.util.ResultUtil;
import com.blibli.academy.project.util.SMSUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import java.util.HashMap;
import java.util.Map;

/**
 * 绑定
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-23 10:59
 */
@Slf4j
@RestController
@RequestMapping("/student")
@Validated
@Api(value = "BindingController",description = "绑定")
public class BindingController {
    @Resource
    EmailUtil emailUtil;
    @Autowired
    StudentService studentService;
    @Resource
    private SMSService smsService;

    @ApiOperation(value = "获取邮箱验证码", notes = "传入用户ID和用户邮箱发送验证码")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path", dataType = "Long"),
            @ApiImplicitParam(name = "email", value = "邮箱", required = true, dataType = "String")}
    )
    @PostMapping("/binding/email/{id}")
    public ResponseVO EmailBinding(@Min(value = 0,message = "id不能小于0")@PathVariable("id") Long id, @RequestBody Map<String, String> email)throws RessNull{
        emailUtil.sendMail(email.get("email"));
        log.debug("获取的验证码为"+ email);
        return ResultUtil.success("邮件发送成功");
    }
    @ApiOperation(value = "效验邮箱验证码", notes = "传入验证码效验")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用户id", paramType = "path", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "captcha", value = "验证码", required = true, dataType = "Integer")}
    )
    @PutMapping("/binding/email/{id}")
    public ResponseVO UpdateEmail(@Min(value = 0,message = "id不为0")@PathVariable("id") Long id,@RequestBody Map<String,String> captcha)throws RessNull{
        log.debug("验证码为"+id + captcha.get("captcha"));
        return ResultUtil.success("验证",studentService.updateEmail(id,captcha.get("captcha")));
    }

    @ApiOperation(value = "获取手机验证码", notes = "传入用户ID和用户电话号码发送验证码")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path", dataType = "Long"),
            @ApiImplicitParam(name = "phoneId", value = "手机号码", required = true, dataType = "Long")}
    )
    @PostMapping("/binding/phone/{id}")
    public ResponseVO PhoneBinding(@PathVariable("id") Long id, @RequestBody Map<String,Object> phoneId)throws ClientException, RessNull{
        log.debug("验证码为" + phoneId);
        return ResultUtil.success("短信发送成功",smsService.sendSMS(id,String.valueOf(phoneId.get("phoneId"))));
    }
    @ApiOperation(value = "效验短信验证码", notes = "传入验证码效验")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用户id", paramType = "path", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "captcha", value = "验证码", required = true, dataType = "Integer")}
    )
    @PutMapping("/binding/phone/{id}")
    public ResponseVO UpdatePhone(@Min(value = 0,message = "id不为0")@PathVariable Long id,@RequestBody Map<String,String> captcha)throws RessNull{
        log.debug("验证码为"+ captcha);
        return ResultUtil.success("验证成功", studentService.updatePhone(id, captcha.get("captcha")));

    }

}
