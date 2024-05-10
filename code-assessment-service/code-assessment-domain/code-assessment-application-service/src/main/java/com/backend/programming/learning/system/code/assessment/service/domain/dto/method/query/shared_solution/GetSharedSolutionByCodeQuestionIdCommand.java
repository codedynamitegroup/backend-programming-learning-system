package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.SharedSolution;
import com.backend.programming.learning.system.domain.valueobject.QueryOrderBy;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class GetSharedSolutionByCodeQuestionIdCommand {
    @NotNull(message = "codeQuestionId must not be null")
    UUID codeQuestionId;

    List<UUID> filterTagIds;

    @Builder.Default
    SharedSolution.SortedFields sortBy = SharedSolution.SortedFields.totalVote;

    @Builder.Default
    QueryOrderBy orderBy = QueryOrderBy.DESC ;

    @Positive(message = "pageSize must be positive")
    Integer pageSize;

    @PositiveOrZero(message = "pageNum must not be negative")
    Integer pageNum;

    public void setPageSize(@Positive(message = "pageSize must be positive") Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setPageNum(@PositiveOrZero(message = "pageNum must not be negative") Integer pageNum) {
        this.pageNum = pageNum;
    }
}
