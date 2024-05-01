package com.backend.programming.learning.system.course.service.domain.dto.method.delete.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.delete.post
 * Create by Dang Ngoc Tien
 * Date 4/20/2024 - 11:27 AM
 * Description: ...
 */
@Builder
public record DeleteQuestionCommand(
        @NotNull(message = "Question id is required")
        UUID questionId) {
}
