package com.backend.programming.learning.system.domain;

import com.backend.programming.learning.system.domain.entity.Question;
import com.backend.programming.learning.system.domain.event.QuestionCreatedEvent;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Slf4j
public class CoreDomainServiceImpl implements CoreDomainService {
    @Override
    public QuestionCreatedEvent createQuestion(Question question) {
        question.initializeQuestion();

        log.info("Question created with id: {}", question.getId().getValue());

        return new QuestionCreatedEvent(question, ZonedDateTime.now(ZoneId.of("UTC")));
    }
}
