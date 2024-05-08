package com.backend.programming.learning.system.course.service.container;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableDiscoveryClient
@EnableFeignClients
@OpenAPIDefinition(info = @Info(
        title = "Course Service API", version = "${springdoc.version}", description = "Documentation Course Service API v1.0"))
@EnableJpaRepositories(basePackages = {"com.backend.programming.learning.system.course.service.dataaccess", "com.backend.programming.learning.system.dataaccess"})
@EntityScan(basePackages = {"com.backend.programming.learning.system.course.service.dataaccess", "com.backend.programming.learning.system.dataaccess"})
@SpringBootApplication(scanBasePackages = "com.backend.programming.learning.system")
public class CourseServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CourseServiceApplication.class, args);
    }
}
