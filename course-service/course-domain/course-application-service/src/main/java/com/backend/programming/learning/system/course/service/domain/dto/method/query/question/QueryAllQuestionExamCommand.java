package com.backend.programming.learning.system.course.service.domain.dto.method.query.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.method.query.question
 * Create by Dang Ngoc Tien
 * Date 5/4/2024 - 2:44 PM
 * Description: ...
 */
@Builder
public record QueryAllQuestionExamCommand(
        UUID examId,
        @NotNull int pageNo,
        @NotNull int pageSize,
        @NotNull String search
) {
}
