package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.TestCaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class GetSharedSolutionsResponse {
    private final List<GetSharedSolutionResponseItem> sharedSolution;
    private final Integer currentPage;
    private final Long totalItems;
    private final Integer totalPages;
}
