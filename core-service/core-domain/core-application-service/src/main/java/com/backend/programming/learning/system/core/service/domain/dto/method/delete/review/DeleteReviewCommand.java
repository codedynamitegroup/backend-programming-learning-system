package com.backend.programming.learning.system.core.service.domain.dto.method.delete.review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteReviewCommand {
    @NotNull(message = "reviewId is required")
    private final UUID reviewId;
    @NotNull(message = "deletedBy is required")
    private final UUID deletedBy;
}
