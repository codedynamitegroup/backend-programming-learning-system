package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignmentOnlineText;

import java.util.Optional;
import java.util.UUID;

public interface SubmissionAssignmentOnlineTextRepository {
    SubmissionAssignmentOnlineText saveAssignmentSubmissionOnlineText(SubmissionAssignmentOnlineText submissionAssignmentOnlineText);

    Optional<SubmissionAssignmentOnlineText> findById(UUID submissionAssignmentOnlineTextId);

    void deleteSubmissionAssignmentOnlineTextById(UUID submissionAssignmentOnlineTextId);
}
