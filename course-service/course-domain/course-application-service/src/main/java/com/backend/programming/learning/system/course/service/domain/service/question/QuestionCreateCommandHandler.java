package com.backend.programming.learning.system.course.service.domain.service.question;

import com.backend.programming.learning.system.course.service.domain.dto.question.create.CreateQuestionCommand;
import com.backend.programming.learning.system.course.service.domain.entity.question.Question;
import com.backend.programming.learning.system.course.service.domain.event.question.QuestionCreateEvent;
import com.backend.programming.learning.system.course.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.question.QuestionRepository;
import com.backend.programming.learning.system.course.service.domain.service.QuestionDomainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * com.backend.programming.learning.system.course.service.domain.service
 * Create by Dang Ngoc Tien
 * Date 3/25/2024 - 11:21 PM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class QuestionCreateCommandHandler {
    private final QuestionDomainService questionDomainService;
    private final QuestionRepository questionRepository;
    private final QuestionDataMapper questionDataMapper;
    @Transactional
    public QuestionCreateEvent createQuestion(CreateQuestionCommand createQuestionCommand) {
        Question question = questionDataMapper.createQuestionToQuestion(createQuestionCommand);
        QuestionCreateEvent questionCreateEvent = questionDomainService.validateAndInitiateQuestion(question);
        Question savedQuestion = questionRepository.createQuestion(questionCreateEvent.getQuestion());
        if (savedQuestion == null) {
            log.error("Error while saving question");
            throw new RuntimeException("Error while saving question");
        }
        log.info("Question saved successfully");
        return questionCreateEvent;
    }
}
