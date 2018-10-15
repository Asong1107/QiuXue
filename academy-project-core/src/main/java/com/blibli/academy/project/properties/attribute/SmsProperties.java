package com.blibli.academy.project.properties.attribute;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-24 13:50
 */
@Configuration
@ConfigurationProperties(prefix = "project.alySMS")
@Data
@Order(-1)
public class SmsProperties {
    private String accessKeyId;
    private String accessKeySecret;
    private String product;
    private String domain;
    private String regionId;
    private String signName;
    private String dateFormat;
    private String endpointName;
    private String templateCode;
}
