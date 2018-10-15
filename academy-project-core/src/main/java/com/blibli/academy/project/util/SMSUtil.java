package com.blibli.academy.project.util;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.blibli.academy.project.codeconst.RessNull;
import com.blibli.academy.project.properties.attribute.SmsProperties;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.aliyuncs.http.MethodType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-09 20:24
 */
@Slf4j
@Component
public class SMSUtil {
    @Autowired
    private SmsProperties smsProperties;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public static SMS newSMS() {
        return new SMS();
    }

    // 一个短信实体
    @Data
    public static class SMS {
        private String phoneNumbers;
        private String templateParam;
        private String outId;
        private String templateCode;

    }

    @Data
    public static class Result {
        private SendSmsResponse sendSmsResponse;
        private SMS sms;
    }

    public Boolean sendSms(Long id, String phoneId) throws ClientException, RessNull {
        SMSUtil.SMS sms = SMSUtil.newSMS();
        sms.setPhoneNumbers(phoneId);
        String code = RandNumUtil.getRandLength(4);
        //存入缓存
        try {
            stringRedisTemplate.opsForValue().set(code, phoneId);
        } catch (RedisConnectionFailureException e) {
            throw new RedisConnectionFailureException("提醒: 短信发送失败");
        }
        // JSON 格式
        sms.setTemplateParam("{\"code\":\"" + code + "\"}");
        log.debug("setTemplateParam" + sms.getTemplateParam());
        SMSUtil.Result result = sendSms(sms);
        log.debug("result:" + JSONObject.toJSONString(result));
        if (result.getSendSmsResponse() == null || !result.getSendSmsResponse().getCode().equals("OK")) {
            throw new RessNull("提醒: 短信发送失败, 每分钟只能发送一次, 每小时最多五次, 每天最多十次~");
        }
        return true;
    }

    /**
     * 发送短信
     * 发送验证码类的短信时，每个号码每分钟最多发送一次，每个小时最多发送5次, 每天最多20次
     * 其它类短信频控请参考阿里云
     *
     * @param sms 短信
     */
    public Result sendSms(SMS sms) throws ClientException {
        IAcsClient acsClient = getClient();
        SendSmsRequest request = getRequest(sms);
        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = acsClient.getAcsResponse(request);
        } catch (ClientException e) {
            throw new ClientException("提醒: 发送短信发生错误。错误代码是:" + e.getErrCode() + " 错误消息是" + e.getMessage() + "错误请求ID是:" + e.getRequestId() + "错误Msg是:" + e.getErrMsg() + "错误类型是" + e.getErrorType());
        }

        Result result = new Result();
        result.setSendSmsResponse(sendSmsResponse);
        result.setSms(sms);
        return result;
    }

    public static Query newQuery() {
        return new Query();
    }


    // 构建一个查询器
    @Data
    public static class Query {

        /**
         * 业务ID
         */
        private String bizId;
        private String phoneNumber;
        private Date sendDate;
        private Long pageSize;
        private Long currentPage;

    }

    /**
     * 查询短信发送结果
     *
     * @param query 查询条件
     */
    public QuerySendDetailsResponse querySendDetails(Query query) {
        IAcsClient acsClient = getClient();
        QuerySendDetailsRequest request = new QuerySendDetailsRequest();
        request.setPhoneNumber(query.getPhoneNumber());
        request.setBizId(query.getBizId());
        SimpleDateFormat ft = new SimpleDateFormat(smsProperties.getDateFormat());
        request.setSendDate(ft.format(query.getSendDate()));
        request.setPageSize(query.getPageSize());
        request.setCurrentPage(query.getCurrentPage());
        QuerySendDetailsResponse querySendDetailsResponse = null;
        try {
            querySendDetailsResponse = acsClient.getAcsResponse(request);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return querySendDetailsResponse;
    }


    // 获取短信请求
    private SendSmsRequest getRequest(SMS sms) {
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(sms.getPhoneNumbers());
        request.setSignName(smsProperties.getSignName());
        // 短信模板
        request.setTemplateCode(smsProperties.getTemplateCode());
        request.setTemplateParam(sms.getTemplateParam());
        request.setOutId(sms.getOutId());
        return request;
    }


    // 获取短信发送服务机
    private IAcsClient getClient() {
        IClientProfile profile = DefaultProfile.getProfile(smsProperties.getRegionId(), smsProperties.getAccessKeyId(), smsProperties.getAccessKeySecret());
        try {
            DefaultProfile.addEndpoint(smsProperties.getEndpointName(), smsProperties.getRegionId(), smsProperties.getProduct(), smsProperties.getDomain());
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return new DefaultAcsClient(profile);
    }
}
