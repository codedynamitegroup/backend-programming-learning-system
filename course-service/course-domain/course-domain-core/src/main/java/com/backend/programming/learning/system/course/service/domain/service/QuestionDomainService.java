package com.backend.programming.learning.system.course.service.domain.service;

import com.backend.programming.learning.system.course.service.domain.entity.question.Question;
import com.backend.programming.learning.system.course.service.domain.event.question.QuestionCreateEvent;

/**
 * com.backend.programming.learning.system.course.service.domain.service
 * Create by Dang Ngoc Tien
 * Date 3/25/2024 - 11:54 PM
 * Description: ...
 */

public interface QuestionDomainService {

    QuestionCreateEvent validateAndInitiateQuestion(Question question);

    QuestionCreateEvent validateAndUpdateQuestion(Long questionId, Question question);
}
