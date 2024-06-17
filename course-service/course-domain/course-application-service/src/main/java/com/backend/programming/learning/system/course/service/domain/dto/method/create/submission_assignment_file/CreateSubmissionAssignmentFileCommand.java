package com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_file;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateSubmissionAssignmentFileCommand {
    private final UUID submissionAssignmentId;

    @NotNull
    private String fileName;
    @NotNull
    private Integer fileSize;
    @NotNull
    private ZonedDateTime timemodified;
    @NotNull
    private String mimetype;
    @NotNull
    private String fileUrl;
}
