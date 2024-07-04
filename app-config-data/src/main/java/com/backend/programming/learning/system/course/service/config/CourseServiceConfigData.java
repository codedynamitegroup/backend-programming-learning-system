package com.backend.programming.learning.system.course.service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "course-service")
public class CourseServiceConfigData {
    private String questionRequestTopicName;
    private String questionResponseTopicName;
  
    private String calendarEventUpdateRequestTopicName;
    private String calendarEventUpdateResponseTopicName;

    private String authServiceUserRequestToCourseServiceTopicName;
    private String courseServiceUserRequestToAuthServiceTopicName;
    private String anyServicesUserResponseToAuthServiceTopicName;
    private String authServiceUserResponseToCourseServiceTopicName;

    private String courseOrganizationRequestTopicName;
    private String organizationResponseTopicName;

    private String geminiApiKey;
    private String geminiApiUrl;
}
