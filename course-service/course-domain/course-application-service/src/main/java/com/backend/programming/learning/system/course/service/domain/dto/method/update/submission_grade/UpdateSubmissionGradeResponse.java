package com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_grade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateSubmissionGradeResponse {
    private UUID id;
    private String message;
}
