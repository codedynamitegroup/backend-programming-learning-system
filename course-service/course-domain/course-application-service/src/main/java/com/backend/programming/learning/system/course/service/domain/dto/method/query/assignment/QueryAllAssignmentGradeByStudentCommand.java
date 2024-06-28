package com.backend.programming.learning.system.course.service.domain.dto.method.query.assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllAssignmentGradeByStudentCommand {
    private final UUID userId;
    private final UUID courseId;
    private final int pageNo;
    private final int pageSize;
    private final String searchName;
}
