package com.backend.programming.learning.system.code.assessment.service.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CodeAssessmentDomainService codeAssessmentDomainService(){
        return new CodeAssessmentDomainServiceImpl();
    }
}
