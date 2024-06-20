package com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_grade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateSubmissionGradeResponse {
    private final UUID id;
    private final String message;
}
