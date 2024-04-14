package com.backend.programming.learning.system.code.assessment.service.domain;


import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.CodeQuestionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.QuestionRepository;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.backend.programming.learning.system")
public class CodeAssessmentTestConfiguration {
    @Bean
    public CodeQuestionRepository codeQuestionRepository(){
        return Mockito.mock(CodeQuestionRepository.class);
    }
    @Bean
    public QuestionRepository  questionRepository(){
        return Mockito.mock(QuestionRepository.class);
    }
    @Bean
    public CodeAssessmentDomainService codeAssessmentDomainService(){
        return new CodeAssessmentDomainServiceImpl();
    }
}
