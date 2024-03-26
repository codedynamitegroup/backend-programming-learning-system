package com.backend.programming.learning.system;

import com.backend.programming.learning.system.course.service.domain.ExamDomainService;
import com.backend.programming.learning.system.course.service.domain.ExamDomainServiceImp;
import com.backend.programming.learning.system.course.service.domain.service.QuestionDomainService;
import com.backend.programming.learning.system.course.service.domain.service.QuestionDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public ExamDomainService courseDomainService() {
        return new ExamDomainServiceImp();
    }
    @Bean
    public QuestionDomainService questionDomainService() {
        return new QuestionDomainServiceImpl();
    }
}