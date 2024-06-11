package com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest_question;

import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.backend.programming.learning.system.domain.valueobject.QuestionType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(NON_NULL)
@NoArgsConstructor(force = true)
public class ContestQuestionResponseEntity {
    @JsonProperty("questionId")
    private final UUID questionId;
    @JsonProperty("codeQuestionId")
    private final UUID codeQuestionId;
    @JsonProperty("difficulty")
    private final QuestionDifficulty difficulty;
    @JsonProperty("name")
    private final String name;
    @JsonProperty("questionText")
    private final String questionText;
    @JsonProperty("generalFeedback")
    private final String generalFeedback;
    @JsonProperty("defaultMark")
    private final Float defaultMark;
    @JsonProperty("maxGrade")
    private final Float maxGrade;
    @JsonProperty("grade")
    private final Float grade;
    @JsonProperty("pass")
    private final Boolean pass;
    @JsonProperty("qtype")
    private final QuestionType qtype;
    @JsonProperty("numOfSubmissions")
    private final Integer numOfSubmissions;
    @JsonProperty("numOfCorrectSubmissions")
    private final Integer numOfCorrectSubmissions;
    @JsonProperty("doTime")
    private final Long doTime;
}
