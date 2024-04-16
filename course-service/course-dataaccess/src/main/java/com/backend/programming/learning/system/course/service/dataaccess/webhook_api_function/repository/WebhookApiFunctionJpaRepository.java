package com.backend.programming.learning.system.course.service.dataaccess.webhook_api_function.repository;

import com.backend.programming.learning.system.course.service.dataaccess.webhook_api_function.entity.WebhookApiFunctionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface WebhookApiFunctionJpaRepository extends JpaRepository<WebhookApiFunctionEntity, UUID> {
    Optional<WebhookApiFunctionEntity> findById(UUID id);
}
