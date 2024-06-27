package com.backend.programming.learning.system.course.service.domain.dto.responseentity.assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class StudentAssignmentList {
    private final List<AssignmentMaxGradeInfo> assignments;
    private final List<StudentGrade> students;
}
