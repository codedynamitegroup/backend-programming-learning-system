package com.backend.programming.learning.system.course.service.domain.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * com.backend.programming.learning.system.course.service.domain.config.exam
 * Create by Dang Ngoc Tien
 * Date 3/21/2024 - 12:17 AM
 * Description: ...
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "course-service")
public class ExamServiceConfigData {
    private String examTopicName;
}
