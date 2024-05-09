package com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommentJpaRepository extends JpaRepository<CommentEntity, UUID> {
}
