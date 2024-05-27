package com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment_onlinetext;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class SubmissionAssignmentOnlineTextResponseEntity {
    private final UUID id;
    private final String content;
}
