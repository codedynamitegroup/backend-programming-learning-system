package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.comment;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.CommentDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionResponseItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class GetSolutionCommentResponse {
    private final List<CommentDto> sharedSolution;
    private final Integer currentPage;
    private final Long totalItems;
    private final Integer totalPages;
}
