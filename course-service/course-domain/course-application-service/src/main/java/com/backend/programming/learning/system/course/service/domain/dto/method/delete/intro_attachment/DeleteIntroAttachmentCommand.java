package com.backend.programming.learning.system.course.service.domain.dto.method.delete.intro_attachment;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteIntroAttachmentCommand
{
    @NotNull(message = "assignmentId is required")
    private final UUID assignmentId;

}

