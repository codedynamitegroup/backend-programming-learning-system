package com.backend.programming.learning.system.core.service.dataaccess.topic_programminglanguage.repository;

import com.backend.programming.learning.system.core.service.dataaccess.topic_programminglanguage.entity.TopicProgrammingLanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TopicProgrammingLanguageJpaRepository extends JpaRepository<TopicProgrammingLanguageEntity, UUID> {
    Optional<TopicProgrammingLanguageEntity> findById(UUID id);
}
