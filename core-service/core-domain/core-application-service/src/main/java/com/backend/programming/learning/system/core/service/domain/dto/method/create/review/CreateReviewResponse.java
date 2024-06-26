package com.backend.programming.learning.system.core.service.domain.dto.method.create.review;

import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateReviewResponse {
    @NotNull
    private final UUID reviewId;
    @NotNull
    private final String message;
}
