package com.backend.programming.learning.system.course.service.container;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.CourseDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CourseDomainService orderDomainService() {return new CourseDomainServiceImpl() {
        };
    }
}
