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

    private String userRequestTopicName;
    private String userResponseTopicName;
    private String codeQuestionUpdateRequestToCoreServiceTopicName;
    private String codeQuestionUpdateResponseFromCoreServiceTopicName;

    private String calendarEventUpdateRequestTopicName;
    private String calendarEventUpdateResponseTopicName;
}
