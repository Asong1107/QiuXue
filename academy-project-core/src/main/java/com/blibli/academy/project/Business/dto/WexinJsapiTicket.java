package com.blibli.academy.project.Business.dto;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-21 13:47
 */
public class WexinJsapiTicket {

    private static String jsapiTicket;

    public static void setJsapiTicket(String accessToken) {
        // 这里由计划任务在项目启动时获取jsapiTicket, 需要将ip加到微信白名单才能获取到.
        WexinJsapiTicket.jsapiTicket = accessToken;
    }

    public static String getJsapiTicket(){
        return jsapiTicket;
    }
}
