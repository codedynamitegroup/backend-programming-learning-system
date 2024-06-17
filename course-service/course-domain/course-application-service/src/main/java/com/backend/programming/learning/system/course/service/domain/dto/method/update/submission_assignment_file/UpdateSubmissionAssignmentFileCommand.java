package com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_assignment_file;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateSubmissionAssignmentFileCommand {
    private UUID submissionAssignmentId;
    private String fileName;
    private Integer fileSize;
    private String fileUrl;
    private String mimetype;
    @NotNull
    private ZonedDateTime timemodified;

}