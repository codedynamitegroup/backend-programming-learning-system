package com.backend.programming.learning.system.code.assessment.service.domain.dto.entity;

import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CodeQuestionDto {
    UUID id;
    String name;
    Boolean done;
    QuestionDifficulty difficulty;
}
