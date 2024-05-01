package com.backend.programming.learning.system.course.service.dataaccess.webhook_function_organization.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.webhook_function_organization.mapper.WebhookFunctionOrganizationDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.webhook_function_organization.repository.WebhookFunctionOrganizationJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.WebhookFunctionOrganization;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.WebhookFunctionOrganizationRepository;
import org.springframework.stereotype.Repository;

@Repository
public class WebhookFunctionOrganizationRepositoryImpl implements WebhookFunctionOrganizationRepository{
    private final WebhookFunctionOrganizationJpaRepository webhookFunctionOrganizationJpaRepository;
    private final WebhookFunctionOrganizationDataAccessMapper webhookFunctionOrganizationDataAccessMapper;

    public WebhookFunctionOrganizationRepositoryImpl(WebhookFunctionOrganizationJpaRepository webhookFunctionOrganizationJpaRepository, WebhookFunctionOrganizationDataAccessMapper webhookFunctionOrganizationDataAccessMapper) {
        this.webhookFunctionOrganizationJpaRepository = webhookFunctionOrganizationJpaRepository;
        this.webhookFunctionOrganizationDataAccessMapper = webhookFunctionOrganizationDataAccessMapper;
    }


    @Override
    public WebhookFunctionOrganization saveWebhookFunctionOrganization(WebhookFunctionOrganization webhookFunctionOrganization) {
        return webhookFunctionOrganizationDataAccessMapper
                .webhookFunctionOrganizationEntityToWebhookFunctionOrganization(webhookFunctionOrganizationJpaRepository
                        .save(webhookFunctionOrganizationDataAccessMapper
                                .webhookFunctionOrganizationToWebhookFunctionOrganizationEntity(webhookFunctionOrganization)));
    }
}
