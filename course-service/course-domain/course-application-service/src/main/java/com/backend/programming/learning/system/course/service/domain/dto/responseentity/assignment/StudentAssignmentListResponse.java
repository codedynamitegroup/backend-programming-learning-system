package com.backend.programming.learning.system.course.service.domain.dto.responseentity.assignment;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class StudentAssignmentListResponse {
    private final List<AssignmentMaxGradeInfo> assignments;
    private final List<StudentGrade> students;
    private final int currentPage;
    private final long totalItems;
    private final int totalPages;
}
