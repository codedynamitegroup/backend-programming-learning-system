package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.ActivityAttachment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ActivityAttachmentRepository {
    void deleteById(UUID activityAttachmentId);

    Optional<ActivityAttachment> findById(UUID activityAttachmentId);

    List<ActivityAttachment> findByAssignmentId(UUID assignmentId);

    ActivityAttachment save(ActivityAttachment activityAttachment);

   Optional<ActivityAttachment> findByFileName(String fileName);
}
