package com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.projection;

import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignment;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignmentFile;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public interface AllSubmissionAssignmentProjection {
    UUID getSubmissionAssignmentId();
    UUID getUserId();
    String getFullName();
    String getEmail();
    ZonedDateTime getSubmitTime();
    ZonedDateTime getTimeModified();

    String getContent();
    String getFeedback();
    Boolean getIsGraded();
}
