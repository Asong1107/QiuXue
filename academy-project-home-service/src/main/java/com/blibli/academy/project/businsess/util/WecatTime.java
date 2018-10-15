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
 * @create: 2018-08-24 09:42
 */
@Slf4j
@EnableScheduling
@Component
public class WecatTime {

    // 第一次延迟2秒执行，当执行完后7100秒再执行
    @Scheduled(initialDelay = 2000, fixedDelay = 7000 * 1000 )
    public void getJsapiTicket() {
        try {
            WexinJsapiTicket.setJsapiTicket(WeChatUtil.getTicket(WeixinAccessToken.getAccessToken()));
            log.info("JsapiTicket定时器启动："+WexinJsapiTicket.getJsapiTicket());
        } catch (Exception e) {
            log.error("获取微信JsapiTicket出错，可能是ip未在白名单, 信息如下");
            e.printStackTrace();
            // 此处可能陷入死循环
        }
    }
}
