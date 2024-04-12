package com.backend.programming.learning.system.core.service.dataaccess.contest_question.repository;

import com.backend.programming.learning.system.core.service.dataaccess.chapter_question.entity.ChapterQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.contest_question.entity.ContestQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContestQuestionJpaRepository extends JpaRepository<ContestQuestionEntity, UUID> {
    Optional<ContestQuestionEntity> findById(UUID id);
}
