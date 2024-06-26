package com.backend.programming.learning.system.code.assessment.service.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "code-assessment-service")
public class CodeAssessmentServiceConfigData {
    private String defaultPageSize;
    private String defaultPageNumber;

    private String codeQuestionUpdateRequestToCoreServiceTopicName;
    private String codeQuestionUpdateResponseFromCoreServiceTopicName;

    private String codeSubmissionUpdateRequestToCoreServiceTopicName;

    private String questionResponseCodeAssessmentTopicName;

    private String assessmentExternalServiceIp;
    private String assessmentExternalServicePort;

    private String acceptedStatusDescription;

    private String authServiceUserRequestToCodeAssessmentServiceTopicName;
    private String anyServicesUserResponseToAuthServiceTopicName;

    @Value("${server.port}")
    Integer serverPort;

}
