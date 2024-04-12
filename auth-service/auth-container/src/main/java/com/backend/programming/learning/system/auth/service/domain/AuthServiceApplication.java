package com.backend.programming.learning.system.auth.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = { "com.backend.programming.learning.system.auth.service.dataaccess", "com.backend.programming.learning.system.dataaccess" })
@EntityScan(basePackages = { "com.backend.programming.learning.system.auth.service.dataaccess", "com.backend.programming.learning.system.dataaccess"})
@SpringBootApplication(scanBasePackages = "com.backend.programming.learning.system")
public class AuthServiceApplication {
    public static void main(String[] args) {
      SpringApplication.run(AuthServiceApplication.class, args);
    }
}
