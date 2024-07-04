package com.backend.programming.learning.system.course.service.domain.dto.method.create.report_grade_essay_ai;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
public record ReportGradeEssayAICommand(@NotNull UUID assignmentId, UUID rubricId, @NotNull String feedbackLanguage) {
}
