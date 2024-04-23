package com.backend.programming.learning.system.dto.method.update.submission_assignment;

import com.backend.programming.learning.system.dataaccess.validator.EnumValidator;
import com.backend.programming.learning.system.valueobject.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateSubmissionAssignmentCommand {
    private final UUID submissionAssignmentId;

    @NotNull
    private final Integer pass_status;

    @NotNull
    private final Float grade;

    @NotNull
    private final String content;

    @NotNull
    private final ZonedDateTime timeSubmit;

}