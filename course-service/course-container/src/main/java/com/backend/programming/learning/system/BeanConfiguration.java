package com.backend.programming.learning.system;

import com.backend.programming.learning.system.course.service.domain.ports.input.service.course.CourseApplicationService;
import com.backend.programming.learning.system.course.service.domain.service.course.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.service.course.CourseDomainServiceImpl;
import com.backend.programming.learning.system.course.service.domain.service.exam.ExamDomainService;
import com.backend.programming.learning.system.course.service.domain.service.exam.ExamDomainServiceImp;
import com.backend.programming.learning.system.course.service.domain.service.question.QuestionDomainService;
import com.backend.programming.learning.system.course.service.domain.service.question.QuestionDomainServiceImpl;
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
    @Bean
    public CourseDomainService examDomainService() {
        return new CourseDomainServiceImpl();
    }
}