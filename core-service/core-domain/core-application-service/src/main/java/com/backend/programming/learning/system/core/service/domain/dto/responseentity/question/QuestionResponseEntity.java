package com.backend.programming.learning.system.core.service.domain.dto.responseentity.question;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.OrganizationResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.backend.programming.learning.system.domain.valueobject.QuestionType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class QuestionResponseEntity {
    private final String id;
    private final OrganizationResponseEntity organization;
    private final QuestionDifficulty difficulty;
    private final String name;
    private final String questionText;
    private final String generalFeedback;
    private final float defaultMark;
    private final Boolean pass;
    private final UserResponseEntity createdBy;
    private final UserResponseEntity updatedBy;
    private final QuestionType qtype;
    private final List<AnswerOfQuestionResponseEntity> answers;
    private final List<String> failureMessages;

    private final ZonedDateTime createdAt;
    private final ZonedDateTime updatedAt;
}
