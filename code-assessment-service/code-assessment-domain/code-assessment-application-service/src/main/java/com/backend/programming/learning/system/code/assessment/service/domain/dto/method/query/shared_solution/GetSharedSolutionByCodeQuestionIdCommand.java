package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.SharedSolution;
import com.backend.programming.learning.system.domain.valueobject.QueryOrderBy;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class GetSharedSolutionByCodeQuestionIdCommand {
    @NotNull(message = "codeQuestionId must not be null")
    UUID codeQuestionId;

    List<UUID> filterTagIds;

    String search;

    @Setter
    SharedSolution.SortedFields sortBy;

    @Setter
    QueryOrderBy orderBy;

    @Positive(message = "pageSize must be positive")
    Integer pageSize;

    @PositiveOrZero(message = "pageNum must not be negative")
    Integer pageNum;

}
