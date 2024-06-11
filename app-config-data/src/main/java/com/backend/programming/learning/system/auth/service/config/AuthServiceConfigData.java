package com.backend.programming.learning.system.auth.service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "auth-service")
public class AuthServiceConfigData {
    private String authServiceUserRequestToCoreServiceTopicName;
    private String authServiceUserRequestToCourseServiceTopicName;
    private String authServiceUserRequestToCodeAssessmentServiceTopicName;
    private String courseServiceUserRequestToAuthServiceTopicName;

    private String anyServicesUserResponseToAuthServiceTopicName;
    private String authServiceUserResponseToCourseServiceTopicName;

    private String coreOrganizationRequestTopicName;
    private String courseOrganizationRequestTopicName;
    private String organizationResponseTopicName;
}
