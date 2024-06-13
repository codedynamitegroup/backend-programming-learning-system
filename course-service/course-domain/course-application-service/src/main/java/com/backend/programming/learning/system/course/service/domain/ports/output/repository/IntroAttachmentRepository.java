package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.IntroAttachment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IntroAttachmentRepository {
    Optional<IntroAttachment> findById(UUID introAttachmentId);

    IntroAttachment save(IntroAttachment introAttachment);

    void deleteById(UUID introAttachmentId);

    List<IntroAttachment> findAllByAssignmentId(UUID assignmentId);

}
