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
    @NotNull(message = "userId must not be null")
    UUID userId;

    @NotNull(message = "sharedSolutionId must not be null")
    @Setter
    @JsonIgnore
    UUID sharedSolutionId;

    @Builder.Default
    QueryOrderBy orderBy = QueryOrderBy.DESC ;

    @Positive(message = "pageSize must be positive")
    @Setter
    @JsonIgnore
    Integer pageSize;

    @PositiveOrZero(message = "pageNum must not be negative")
    @Setter
    @JsonIgnore
    Integer pageNum;
}
