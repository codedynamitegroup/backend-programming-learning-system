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

import java.util.List;

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
    public QuestionCreateEvent createQuestion(Long examId, CreateQuestionCommand createQuestionCommand) {
        Question question = questionDataMapper.createQuestionToQuestion(createQuestionCommand);
        QuestionCreateEvent questionCreateEvent = questionDomainService.validateAndInitiateQuestion(question);
        Question savedQuestion = questionRepository.createQuestion(examId, questionCreateEvent.getQuestion());
        if (savedQuestion == null) {
            log.error("Error while saving question");
            throw new RuntimeException("Error while saving question");
        }
        log.info("Question saved successfully");
        return questionCreateEvent;
    }

    @Transactional(readOnly = true)
    public List<Question> getQuestions(Long examId) {
        return questionRepository.getQuestionsByExamId(examId);
    }

    @Transactional
    public void deleteQuestion(Long examId, Long questionId) {
        questionRepository.deleteQuestion(examId, questionId);
    }

    @Transactional(readOnly = true)
    public Question getQuestion(Long questionId) {
        return questionRepository.getQuestionById(questionId);
    }

    @Transactional
    public QuestionCreateEvent updateQuestion(Long examId, Long questionId, CreateQuestionCommand createQuestionCommand) {
        Question question = questionDataMapper.createQuestionToQuestion(createQuestionCommand);
        QuestionCreateEvent questionCreateEvent = questionDomainService.validateAndUpdateQuestion(questionId, question);
        Question savedQuestion = questionRepository.updateQuestion(examId, questionId, questionCreateEvent.getQuestion());
        if (savedQuestion == null) {
            log.error("Error while saving question");
            throw new RuntimeException("Error while saving question");
        }
        log.info("Question updated successfully");
        return questionCreateEvent;
    }
}
