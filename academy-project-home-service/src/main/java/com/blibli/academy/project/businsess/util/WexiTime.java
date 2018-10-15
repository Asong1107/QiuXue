package com.blibli.academy.project.businsess.util;

import com.blibli.academy.project.Business.dto.WeixinAccessToken;
import com.blibli.academy.project.Business.dto.WexinJsapiTicket;
import com.blibli.academy.project.util.WeChatUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-24 08:55
 */
@Slf4j
@EnableScheduling
@Component
public class WexiTime {

    // 第一次延迟1秒执行，当执行完后7100秒再执行
    @Scheduled(initialDelay = 1000, fixedDelay = 7000 * 1000 )
    public void getWeixinAccessToken(){
        try {
            String token = WeChatUtil.getToken(WeChatUtil.APPID, WeChatUtil.APPSECRET).getAccess_token();
            WeixinAccessToken.setAccessToken(token);
            log.info("获取到的微信accessToken为"+token);
        } catch (Exception e) {
            log.error("获取微信adcessToken出错，信息如下");
            e.printStackTrace();
            // 此处可能陷入死循环
        }
    }
}
