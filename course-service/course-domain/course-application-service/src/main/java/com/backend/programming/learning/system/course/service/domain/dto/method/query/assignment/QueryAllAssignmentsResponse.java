package com.backend.programming.learning.system.course.service.domain.dto.method.query.assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllAssignmentsResponse {
    @NotNull
    private final List<QueryAssignmentResponse> assignments;
    @NotNull
    private final int currentPage;
    @NotNull
    private final long totalItems;
    @NotNull
    private final int totalPages;
}
