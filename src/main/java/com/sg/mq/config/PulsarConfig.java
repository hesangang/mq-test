package com.sg.mq.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Data;
@Data
@Configuration
@ConfigurationProperties(prefix = "pulsar")
public class PulsarConfig {
    /**
     * pulsar服务端地址
     */
    private String url;
    /**
     * topic
     */
    private String topic;
    /**
     * 消费者组
     */
    private String subscription;
}
