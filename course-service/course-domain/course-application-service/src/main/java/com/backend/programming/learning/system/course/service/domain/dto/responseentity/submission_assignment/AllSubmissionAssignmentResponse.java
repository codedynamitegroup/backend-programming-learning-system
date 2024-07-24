package com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment_file.SubmissionAssignmentFileResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_grade.SubmissionGradeResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignmentFile;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
public class AllSubmissionAssignmentResponse {
    UUID id;
    UUID userId;
    String fullName;
    String email;
    String assignmentName;
    List<SubmissionAssignmentFileResponseEntity> submissionAssignmentFiles;
    SubmissionGradeResponseEntity submissionGrade;
    String content;
    String feedback;
    Boolean isGraded;
    ZonedDateTime submitTime;
    ZonedDateTime timemodified;
}
