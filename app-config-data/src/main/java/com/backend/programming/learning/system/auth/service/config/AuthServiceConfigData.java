package com.backend.programming.learning.system.auth.service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "auth-service")
public class AuthServiceConfigData {
    private String coreUserRequestTopicName;
    private String courseUserRequestTopicName;
    private String codeAssessmentUserRequestTopicName;
    private String userResponseTopicName;

    private String coreOrganizationRequestTopicName;
    private String courseOrganizationRequestTopicName;
    private String organizationResponseTopicName;
}
