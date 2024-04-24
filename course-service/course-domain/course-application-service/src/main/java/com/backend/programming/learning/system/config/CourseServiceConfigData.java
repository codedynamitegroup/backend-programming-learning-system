package com.backend.programming.learning.system.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "course-service")
public class CourseServiceConfigData {
    private String questionCreatedRequestTopicName;
    private String questionDeletedRequestTopicName;
    private String questionUpdatedRequestTopicName;
}
