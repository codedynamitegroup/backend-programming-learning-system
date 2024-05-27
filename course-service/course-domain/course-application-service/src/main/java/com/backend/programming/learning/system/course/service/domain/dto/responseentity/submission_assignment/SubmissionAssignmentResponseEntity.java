package com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment_file.SubmissionAssignmentFileResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment_onlinetext.SubmissionAssignmentOnlineTextResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
@Getter
@Builder
@AllArgsConstructor
public class SubmissionAssignmentResponseEntity {
    private final UUID id;
    private final UUID userId;
    private final Boolean isGraded;
    private final SubmissionAssignmentFileResponseEntity submissionAssignmentFile;
    private final SubmissionAssignmentOnlineTextResponseEntity submissionAssignmentOnlineText;
    private final Float grade;
    private final String content;
    private final ZonedDateTime timemodefied;
    private final ZonedDateTime submitTime;
}
