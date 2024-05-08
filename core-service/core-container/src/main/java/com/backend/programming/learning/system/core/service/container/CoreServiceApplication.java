package com.backend.programming.learning.system.core.service.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableDiscoveryClient
@EnableJpaRepositories(basePackages = { "com.backend.programming.learning.system.core.service.dataaccess", "com.backend.programming.learning.system.dataaccess" })
@EntityScan(basePackages = { "com.backend.programming.learning.system.core.service.dataaccess", "com.backend.programming.learning.system.dataaccess" })
@SpringBootApplication(scanBasePackages = "com.backend.programming.learning.system")
public class CoreServiceApplication {
    public static void main(String[] args) {
      SpringApplication.run(CoreServiceApplication.class, args);
    }
}
