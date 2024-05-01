package com.backend.programming.learning.system.code.assessment.service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "code-assessment-service")
public class CodeAssessmentServiceConfigData {
    private String codeQuestionUpdateRequestToCoreServiceTopicName;
    private String codeQuestionUpdateResponseFromCoreServiceTopicName;
}
