package com.backend.programming.learning.system.domain;

import com.backend.programming.learning.system.domain.entity.Question;
import com.backend.programming.learning.system.domain.event.Question.QuestionCreatedEvent;

public interface CoreDomainService {
    QuestionCreatedEvent createQuestion(Question question);
}