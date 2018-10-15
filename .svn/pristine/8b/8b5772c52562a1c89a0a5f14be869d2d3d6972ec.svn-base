package com.blibli.academy.project.service.impl;

import com.blibli.academy.project.Business.dto.WexinJsapiTicket;
import com.blibli.academy.project.Business.dto.WeChatTokenDto;
import com.blibli.academy.project.Business.dto.WeChatUserDto;
import com.blibli.academy.project.Business.pojo.User;
import com.blibli.academy.project.codeconst.RessNull;
import com.blibli.academy.project.mapper.UserMapper;
import com.blibli.academy.project.service.WechatService;
import com.blibli.academy.project.util.WeChatUtil;
import com.blibli.academy.project.util.WechatSignUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * 微信
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-21 02:25
 */
@Service
@Slf4j
public class WechatServiceImpl implements WechatService {

    @Autowired
    UserMapper userMapper;

    @Override
    public WeChatUserDto userLogin(String code) throws RessNull {
        WeChatTokenDto weChatTokenDto = WeChatUtil.getTokenBycode(WeChatUtil.APPID, WeChatUtil.APPSECRET, code);
        String accessToken = weChatTokenDto.getAccess_token();
        String openId = weChatTokenDto.getOpenid();
        User user1 = new User();
        user1.setOpenid(openId);
        //数据库里用户的信息
        User user = userMapper.selectOne(user1);
        //返回信息
        WeChatUserDto weChatUserDto = new WeChatUserDto();
        if (user != null) {
            weChatUserDto.setOpenid(user.getOpenid());
            weChatUserDto.setId(user.getId());
            // 状态false的用户禁止访问
            weChatUserDto.setStatus(user.getStatus());
            return weChatUserDto;
        } else {
            weChatUserDto = WeChatUtil.getUserInfo(accessToken, openId);
            //新建用户
            User newUser = new User();
            newUser.setOpenid(weChatUserDto.getOpenid());
            newUser.setNickname(weChatUserDto.getNickname());
            newUser.setHeadImgUrl(weChatUserDto.getHeadImgUrl());
            newUser.setAddress(weChatUserDto.getCity());
            newUser.setData(0);
            newUser.setBinding(false);
            newUser.setStatus(true);
            newUser.setCreateAt(new Date());
            newUser.setCreateBy("系统创建");
            userMapper.insert(newUser);
            /*
            //新建后用户（为了取自增的ID）
            User user2 = userMapper.selectOne(newUser);*/
            //新建一个返回值
            // weChatUserDto.setOpenId(newUser.getOpenId());
            WeChatUserDto weChatUserBack = new WeChatUserDto();
            weChatUserBack.setId(newUser.getId());
            weChatUserBack.setOpenid(weChatTokenDto.getOpenid());
            // 状态false的用户禁止访问
            weChatUserBack.setStatus(newUser.getStatus());
            return weChatUserBack;
        }
    }

    @Override
    public Map<String, String> weChatAuthority(String url) throws RessNull{
        String jsapiTicket = WexinJsapiTicket.getJsapiTicket();
        if (jsapiTicket == null || jsapiTicket.equals("")) {
            throw new RessNull("提醒: 后台 jsapiTicket 获取失败, 请稍后再试~");
        }
        return WechatSignUtil.getWexinAuthority(jsapiTicket, url);
    }
}