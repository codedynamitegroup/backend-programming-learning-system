package com.backend.programming.learning.system.code.assessment.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.backend.programming.learning.system.code.assessment.service.dataaccess")
@EnableJpaRepositories(basePackages = "com.backend.programming.learning.system.code.assessment.service.dataaccess")
@SpringBootApplication(scanBasePackages = "com.backend.programming.learning.system")
public class CodeAssessmentServiceApplication {
    public static void main(String args[]){
        SpringApplication.run(CodeAssessmentServiceApplication.class, args);
    }
}
