package com.blibli.academy.project.properties.attribute;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * 七牛配置
 * @author blibli
 * @program: project
 * @create: 2018-08-14 23:17
 */
@Configuration
@ConfigurationProperties(prefix = "project.qiniu")
@Data
@Order(-1)
public class QiniuProperties {
    private String access_key_id;
    private String access_key_secret;
    private String bucket_name;
    private String endpoint;
    private String file_url;

}
