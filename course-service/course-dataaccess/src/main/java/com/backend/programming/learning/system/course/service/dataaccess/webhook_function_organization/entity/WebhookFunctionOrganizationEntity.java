package com.backend.programming.learning.system.course.service.dataaccess.webhook_function_organization.entity;

import com.backend.programming.learning.system.course.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.course.service.dataaccess.webhook_api_function.entity.WebhookApiFunctionEntity;
import lombok.*;

import jakarta.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class WebhookFunctionOrganizationEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "org_id", referencedColumnName = "id")
    private OrganizationEntity organization;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "webhook_function_id", referencedColumnName = "id")
    private WebhookApiFunctionEntity webhookApiFunction;
}

