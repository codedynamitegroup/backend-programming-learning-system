package com.backend.programming.learning.system.core.service.domain.dto.responseentity.question;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class QtypeCodeQuestionResponseEntity {
    private final String id;
    private final QuestionResponseEntity question;
    private final String dslTemplate;
    private final String problemStatement;
    private final String codeQuestionName;
    private final Boolean isPublic;
    private final Float maxGrade;
}
