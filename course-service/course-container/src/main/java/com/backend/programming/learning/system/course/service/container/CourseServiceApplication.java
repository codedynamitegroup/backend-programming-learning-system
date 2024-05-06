package com.backend.programming.learning.system.course.service.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableDiscoveryClient
@EnableJpaRepositories(basePackages = {"com.backend.programming.learning.system.course.service.dataaccess", "com.backend.programming.learning.system.dataaccess"})
@EntityScan(basePackages = {"com.backend.programming.learning.system.course.service.dataaccess", "com.backend.programming.learning.system.dataaccess"})
@SpringBootApplication(scanBasePackages = "com.backend.programming.learning.system")
public class CourseServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CourseServiceApplication.class, args);
    }
}
