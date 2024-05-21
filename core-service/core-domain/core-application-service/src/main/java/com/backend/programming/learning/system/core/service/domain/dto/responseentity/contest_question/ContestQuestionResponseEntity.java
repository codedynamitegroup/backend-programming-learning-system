package com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest_question;

import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.backend.programming.learning.system.domain.valueobject.QuestionType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class ContestQuestionResponseEntity {
    private final UUID questionId;
    private final UUID codeQuestionId;
    private final QuestionDifficulty difficulty;
    private final String name;
    private final String questionText;
    private final String generalFeedback;
    private final Float defaultMark;
    private final Float grade;
    private final Boolean pass;
    private final QuestionType qtype;
    private final Integer numOfSubmissions;
    private final Integer doTime;
}
