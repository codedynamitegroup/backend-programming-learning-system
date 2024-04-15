package com.backend.programming.learning.system.core.service.container;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.CoreDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CoreDomainService orderDomainService() {
        return new CoreDomainServiceImpl();
    }
}
