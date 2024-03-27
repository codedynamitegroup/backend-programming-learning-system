package com.backend.programming.learning.system.course.service.domain.service;

import com.backend.programming.learning.system.course.service.domain.entity.question.Question;
import com.backend.programming.learning.system.course.service.domain.event.question.QuestionCreateEvent;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

/**
 * com.backend.programming.learning.system.course.service.domain.service
 * Create by Dang Ngoc Tien
 * Date 3/25/2024 - 11:54 PM
 * Description: ...
 */
@Slf4j
public class QuestionDomainServiceImpl implements QuestionDomainService{
    @Override
    public QuestionCreateEvent validateAndInitiateQuestion(Question question) {
        log.info("validateAndInitiateQuestion");
        return new QuestionCreateEvent(question, LocalDateTime.now());
    }

    @Override
    public QuestionCreateEvent validateAndUpdateQuestion(Long questionId, Question question) {
        log.info("validateAndUpdateQuestion");
        return new QuestionCreateEvent(question, LocalDateTime.now());
    }
}
