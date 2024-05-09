package com.backend.programming.learning.system.course.service.domain.dto.method.query.submission_assignment_onlinetext;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QuerySubmissionAssignmentOnlineTextCommand {
    @NotNull
    private final UUID submissionAssignmentOnlineTextId;
}
