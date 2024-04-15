package com.backend.programming.learning.system.core.service.dataaccess.topic.repository;

import com.backend.programming.learning.system.core.service.dataaccess.topic.entity.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TopicJpaRepository extends JpaRepository<TopicEntity, UUID> {
    Optional<TopicEntity> findById(UUID id);
}
