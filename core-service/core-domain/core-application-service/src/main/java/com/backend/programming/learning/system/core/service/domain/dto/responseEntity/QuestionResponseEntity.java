package com.backend.programming.learning.system.core.service.domain.dto.responseEntity;

import com.backend.programming.learning.system.core.service.domain.entity.AnswerOfQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Organization;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.backend.programming.learning.system.domain.valueobject.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.List;


@Getter
@Builder
@AllArgsConstructor
public class QuestionResponseEntity {
//    private final Question question;
    private final String id;
    private final Organization organization;
    private final QuestionDifficulty difficulty;
    private final String name;
    private final String questionText;
    private final String generalFeedback;
    private final float defaultMark;
    private final User createdBy;
    private final User updatedBy;
    private final QuestionType qtype;
    private final List<AnswerOfQuestion> answers;
    private final List<String> failureMessages;

    private final ZonedDateTime createdAt;
    private final ZonedDateTime updatedAt;
}
