package com.backend.programming.learning.system.course.service.dataaccess.activity_attachment.repository;

import com.backend.programming.learning.system.course.service.dataaccess.activity_attachment.entity.ActivityAttachmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ActivityAttachmentJpaRepository extends JpaRepository<ActivityAttachmentEntity, UUID>{
    Optional<ActivityAttachmentEntity> findById(UUID id);

    List<ActivityAttachmentEntity> findAllByAssignmentId(UUID assignmentId);

    Optional<ActivityAttachmentEntity> findByFileName(String fileName);
}
