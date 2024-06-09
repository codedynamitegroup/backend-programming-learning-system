package com.backend.programming.learning.system.core.service.domain.dto.responseentity.chapter;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.OrganizationResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.AnswerOfQuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.backend.programming.learning.system.domain.valueobject.QuestionType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(NON_NULL)
@NoArgsConstructor(force = true)
public class ChapterQuestionResponseEntity {
    @JsonProperty("id")
    private final String id;
    @JsonProperty("difficulty")
    private final QuestionDifficulty difficulty;
    @JsonProperty("name")
    private final String name;
    @JsonProperty("questionText")
    private final String questionText;
    @JsonProperty("generalFeedback")
    private final String generalFeedback;
    @JsonProperty("defaultMark")
    private final float defaultMark;
    @JsonProperty("pass")
    private final Boolean pass;
    @JsonProperty("createdBy")
    private final UserResponseEntity createdBy;
    @JsonProperty("updatedBy")
    private final UserResponseEntity updatedBy;
    @JsonProperty("qtype")
    private final QuestionType qtype;
    @JsonProperty("createdAt")
    private final ZonedDateTime createdAt;
    @JsonProperty("updatedAt")
    private final ZonedDateTime updatedAt;
}
