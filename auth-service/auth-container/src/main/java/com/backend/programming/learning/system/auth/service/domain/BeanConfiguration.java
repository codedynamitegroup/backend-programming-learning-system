package com.backend.programming.learning.system.auth.service.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public AuthDomainService orderDomainService() {
        return new AuthDomainServiceImpl();
    }
}
