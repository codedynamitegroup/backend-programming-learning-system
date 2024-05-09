package com.backend.programming.learning.system.code.assessment.service.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "code-assessment-service")
public class CodeAssessmentServiceConfigData {
    private String codeQuestionUpdateRequestToCoreServiceTopicName;
    private String codeQuestionUpdateResponseFromCoreServiceTopicName;

    private String questionResponseCodeAssessmentTopicName;

    private String assessmentExternalServiceIp;
    private String assessmentExternalServicePort;

    private String acceptedStatusDescription;

    private String codeAssessmentUserRequestTopicName;
    private String userResponseTopicName;

    @Value("${server.port}")
    Integer serverPort;

}
