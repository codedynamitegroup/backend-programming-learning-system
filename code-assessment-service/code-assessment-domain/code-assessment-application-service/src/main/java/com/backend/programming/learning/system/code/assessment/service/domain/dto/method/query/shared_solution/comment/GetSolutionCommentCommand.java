package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.comment;

import com.backend.programming.learning.system.domain.valueobject.QueryOrderBy;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class GetSolutionCommentCommand {
    @NotNull(message = "email must not be null")
    String email;

    @NotNull(message = "sharedSolutionId must not be null")
    UUID sharedSolutionId;

    @NotNull
    QueryOrderBy orderBy;

    @Positive(message = "pageSize must be positive")
    Integer pageSize;

    @PositiveOrZero(message = "pageNum must not be negative")
    Integer pageNum;
}
