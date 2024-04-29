package com.backend.programming.learning.system.course.service.domain.dto.method.message.organization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
@AllArgsConstructor
public class OrganizationCreateRequest {
    private String id;
    private String sagaId;
    private String organizationId;
    private String name;
    private String description;
    private String moodle_url;
    private String apiKey;
    private Instant createdAt;
    private Instant updatedAt;
}
