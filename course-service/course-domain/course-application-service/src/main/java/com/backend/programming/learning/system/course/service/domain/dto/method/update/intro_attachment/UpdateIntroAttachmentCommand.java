package com.backend.programming.learning.system.course.service.domain.dto.method.update.intro_attachment;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;
@Getter
@Builder
@AllArgsConstructor
public class UpdateIntroAttachmentCommand
{
    private final UUID assignmentId;
    private final String fileName;
    private final Integer fileSize;
    private final String fileUrl;
    private final String mimeType;
    private final ZonedDateTime timeModified;
}
