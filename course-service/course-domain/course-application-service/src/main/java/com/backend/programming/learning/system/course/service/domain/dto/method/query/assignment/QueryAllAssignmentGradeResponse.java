package com.backend.programming.learning.system.course.service.domain.dto.method.query.assignment;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.assignment.AssignmentGradeResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllAssignmentGradeResponse {
    List<AssignmentGradeResponseEntity> assignments;
    Integer countSubmission;
    private final int currentPage;
    private final long totalItems;
    private final int totalPages;
}
