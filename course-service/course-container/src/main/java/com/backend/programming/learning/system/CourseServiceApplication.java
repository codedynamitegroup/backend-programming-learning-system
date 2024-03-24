package com.backend.programming.learning.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.backend.programming.learning.system.course.service.dataaccess"})
@EntityScan(basePackages = {"com.backend.programming.learning.system.course.service.dataaccess"})
@SpringBootApplication(scanBasePackages = {"com.backend.programming.learning.system", "com.backend.programming.learning.system.course.service"})
public class CourseServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CourseServiceApplication.class, args);
        System.out.println("Hello world!");
    }
}