package com.backend.programming.learning.system.course.service.domain.dto.responseentity.user;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment.SubmissionAssignmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment.SubmissionAssignmentUserResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UserSubmissionAssignmentResponseEntity {
    private final UUID id;
    private final String fullName;
    private final String email;
    private final SubmissionAssignmentUserResponseEntity submissionAssignmentUserResponseEntity;
}
