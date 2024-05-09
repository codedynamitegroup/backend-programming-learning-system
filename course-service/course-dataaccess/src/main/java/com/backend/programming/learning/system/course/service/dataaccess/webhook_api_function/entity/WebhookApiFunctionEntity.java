package com.backend.programming.learning.system.course.service.dataaccess.webhook_api_function.entity;

import com.backend.programming.learning.system.course.service.dataaccess.organization.entity.OrganizationEntity;
import lombok.*;

import jakarta.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "webhook_api_function")
public class WebhookApiFunctionEntity {

    @Id
    @Column(name = "id")
    private UUID id;
    private String area;

    private String name;
    private String description;

}
