package com.backend.programming.learning.system.course.service.domain.dto.method.create.intro_attachment;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateIntroAttachmentCommand
{
    private final UUID assignmentId;
    @NotNull(message = "File name is required")
    private final String fileName;
    @NotNull(message = "File size is required")
    private final Integer fileSize;
    @NotNull(message = "File URL is required")
    private final String fileUrl;
    @NotNull(message = "MIME type is required")
    private final String mimeType;
    @NotNull(message = "Time created is required")
    private final ZonedDateTime timeModified;
}

