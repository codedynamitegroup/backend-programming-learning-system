package com.backend.programming.learning.system.core.service.domain.dto.method.update.review;

import com.backend.programming.learning.system.core.service.domain.dto.validator.contest.UpdateContestCommandStartTimeAndEndTimeValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateReviewCommand {
    private final UUID reviewId;
    private final Float rating;
    private final String content;
    @NotNull
    private final UUID updatedBy;
}
