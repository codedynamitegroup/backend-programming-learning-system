package com.backend.programming.learning.system.auth.service.container;

import com.backend.programming.learning.system.auth.service.domain.AuthDomainService;
import com.backend.programming.learning.system.auth.service.domain.AuthDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public AuthDomainService authDomainService() {
        return new AuthDomainServiceImpl();
    }
}
