package com.backend.programming.learning.system.course.service.dataaccess.intro_attachment.repository;

import com.backend.programming.learning.system.course.service.dataaccess.intro_attachment.entity.IntroAttachmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IntroAttachmentJpaRepository extends JpaRepository<IntroAttachmentEntity, UUID>{
    Optional<IntroAttachmentEntity> findById(UUID id);

    List<IntroAttachmentEntity> findAllByAssignmentId(UUID assignmentId);

    void deleteByAssignmentId(UUID assignmentId);
}
