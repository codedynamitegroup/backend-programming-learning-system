package com.backend.programming.learning.system.core.service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "core-service")
public class CoreServiceConfigData {
    private String questionRequestTopicName;
    private String questionResponseTopicName;

    private String questionRequestCodeAssessmentTopicName;
    private String questionResponseCodeAssessmentTopicName;

    private String authServiceUserRequestToCoreServiceTopicName;
    private String anyServicesUserResponseToAuthServiceTopicName;

    private String codeQuestionUpdateRequestToCoreServiceTopicName;
    private String codeQuestionUpdateResponseFromCoreServiceTopicName;

    private String calendarEventUpdateRequestTopicName;
    private String calendarEventUpdateResponseTopicName;

    private String coreOrganizationRequestTopicName;
    private String organizationResponseTopicName;
}
