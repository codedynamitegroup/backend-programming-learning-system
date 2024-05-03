package com.backend.programming.learning.system.auth.service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "auth-service")
public class AuthServiceConfigData {
    private String userRequestTopicName;
    private String userResponseTopicName;

    private String organizationRequestTopicName;
    private String organizationResponseTopicName;
}
