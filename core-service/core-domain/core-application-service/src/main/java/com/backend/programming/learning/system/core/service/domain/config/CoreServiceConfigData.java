package com.backend.programming.learning.system.core.service.domain.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "core-service")
public class CoreServiceConfigData {
    private String questionCreatedRequestTopicName;
    private String questionDeletedRequestTopicName;
    private String questionUpdatedRequestTopicName;
}
