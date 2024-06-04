package com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment_file.SubmissionAssignmentFileResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment_onlinetext.SubmissionAssignmentOnlineTextResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_grade.SubmissionGradeResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.user.UserResponseEntity;
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
    private final UserResponseEntity user;
    private final Boolean isGraded;
    private final SubmissionAssignmentFileResponseEntity submissionAssignmentFile;
    private final SubmissionAssignmentOnlineTextResponseEntity submissionAssignmentOnlineText;
    private final SubmissionGradeResponseEntity submissionGrade;
    private final Float grade;
    private final String content;
    private final ZonedDateTime timemodefied;
    private final ZonedDateTime submitTime;
}
