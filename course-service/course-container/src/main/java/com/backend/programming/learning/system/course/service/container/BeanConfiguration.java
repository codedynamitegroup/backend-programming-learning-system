package com.backend.programming.learning.system.course.service.container;

import com.backend.programming.learning.system.CourseDomainService;
import com.backend.programming.learning.system.CourseDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CourseDomainService orderDomainService() {return new CourseDomainServiceImpl() {
        };
    }
}
