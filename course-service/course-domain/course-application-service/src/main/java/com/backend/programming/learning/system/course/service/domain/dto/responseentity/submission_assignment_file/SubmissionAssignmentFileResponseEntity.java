package com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment_file;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class SubmissionAssignmentFileResponseEntity {
    private final UUID id;
    private String fileName;
    private Integer fileSize;
    private ZonedDateTime timemodified;
    private String mimetype;
    private String fileUrl;
}
