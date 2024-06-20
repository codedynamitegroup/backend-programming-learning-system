package com.backend.programming.learning.system.core.service.domain.dto.method.query.question;

import com.backend.programming.learning.system.domain.valueobject.QueryOrderBy;
import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllAdminCodeQuestionCommand {

    @Positive(message = "pageSize must be positive")
    @Setter
    @JsonIgnore
    Integer pageSize;

    @PositiveOrZero(message = "pageNum must not be negative")
    @Setter
    @JsonIgnore
    Integer pageNum;

    String search;
    QuestionDifficulty difficulty;
    Boolean isPublic;
    UUID orgId;
    String email;
}
