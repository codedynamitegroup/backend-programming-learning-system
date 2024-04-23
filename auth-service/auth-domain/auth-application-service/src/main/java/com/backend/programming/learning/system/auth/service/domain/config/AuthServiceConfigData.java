package com.backend.programming.learning.system.auth.service.domain.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "auth-service")
public class AuthServiceConfigData {
    private String userCreateRequestTopicName;
    private String userUpdateRequestTopicName;
    private String userDeleteRequestTopicName;
    private String userResponseTopicName;
}
