package com.backend.programming.learning.system.course.service.domain.dto.method.query.submission_grade;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QuerySubmissionGradeCommand {
    @NotNull
    private final UUID submissionId;
}
