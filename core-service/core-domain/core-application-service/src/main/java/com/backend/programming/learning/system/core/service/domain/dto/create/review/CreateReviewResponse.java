package com.backend.programming.learning.system.core.service.domain.dto.create.review;

import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class CreateReviewResponse {
    @NotNull
    private final Review review;
    @NotNull
    private final String message;
}
