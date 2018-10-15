package com.blibli.academy.project.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-24 13:47
 */
@Configuration
public class JsonUtil
    {
        @Bean
        @Primary
        @ConditionalOnMissingBean(ObjectMapper.class)
        public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder)
        {
            ObjectMapper objectMapper = builder.createXmlMapper(false).build();
            /* 为空的不参加序列化 */
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            return objectMapper;
        }
    }

