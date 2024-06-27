package com.backend.programming.learning.system.course.service.domain.dto.responseentity.assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AssignmentMaxGradeInfo {
    private final String name;
    private final Float maxGrade;
}
