package com.backend.programming.learning.system.code.assessment.service.domain.dto.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
@AllArgsConstructor
public class OrganizationsUpdate {
    private String organizationId;
    private String name;
    private String description;
    private String moodleUrl;
    private Instant createdAt;
    private Instant updatedAt;
}
