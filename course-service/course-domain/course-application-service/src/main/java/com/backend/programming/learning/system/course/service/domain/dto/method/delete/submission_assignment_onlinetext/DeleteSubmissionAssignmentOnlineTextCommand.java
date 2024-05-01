package com.backend.programming.learning.system.course.service.domain.dto.method.delete.submission_assignment_onlinetext;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteSubmissionAssignmentOnlineTextCommand {
    @NotNull
    private final UUID submissionAssignmentOnlineTextId;

}
