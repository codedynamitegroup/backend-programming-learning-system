package com.backend.programming.learning.system.course.service.dataaccess.webhook_function_organization.repository;

import com.backend.programming.learning.system.course.service.dataaccess.webhook_function_organization.entity.WebhookFunctionOrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface WebhookFunctionOrganizationJpaRepository extends JpaRepository<WebhookFunctionOrganizationEntity, UUID> {
    Optional<WebhookFunctionOrganizationEntity> findById(UUID id);
}
