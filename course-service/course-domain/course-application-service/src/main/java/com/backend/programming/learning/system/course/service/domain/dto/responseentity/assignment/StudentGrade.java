package com.backend.programming.learning.system.course.service.domain.dto.responseentity.assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class StudentGrade {
    private final String fullName;
    private final String email;
    private final List<Float> grades;
}
