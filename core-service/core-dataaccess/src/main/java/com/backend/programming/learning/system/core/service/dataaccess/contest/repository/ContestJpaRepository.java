package com.backend.programming.learning.system.core.service.dataaccess.contest.repository;

import com.backend.programming.learning.system.core.service.dataaccess.chapter_question.entity.ChapterQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.contest.entity.ContestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContestJpaRepository extends JpaRepository<ContestEntity, UUID> {
    Optional<ContestEntity> findById(UUID id);
}
