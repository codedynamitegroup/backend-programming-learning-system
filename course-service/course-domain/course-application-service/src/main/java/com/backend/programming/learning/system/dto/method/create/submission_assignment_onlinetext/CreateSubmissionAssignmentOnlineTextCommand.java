package com.backend.programming.learning.system.dto.method.create.submission_assignment_onlinetext;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateSubmissionAssignmentOnlineTextCommand {
    @NotNull
    private final UUID submissionAssignmentId;

    @NotNull
    private final String content;
}
