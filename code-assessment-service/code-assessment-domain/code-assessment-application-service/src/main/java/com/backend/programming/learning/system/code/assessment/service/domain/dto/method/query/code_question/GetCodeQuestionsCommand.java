package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.domain.valueobject.QueryOrderBy;
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

@AllArgsConstructor
@Builder
@Getter
public class GetCodeQuestionsCommand {
    @Positive(message = "pageSize must be positive")
    @Setter
    @JsonIgnore
    Integer pageSize;

    @PositiveOrZero(message = "pageNum must not be negative")
    @Setter
    @JsonIgnore
    Integer pageNum;

    List<UUID> tagIds;
    QueryOrderBy orderBy;
    CodeQuestion.Fields sortBy;

    @NotNull(message = "userId must not be null")
    UUID userId;
}
