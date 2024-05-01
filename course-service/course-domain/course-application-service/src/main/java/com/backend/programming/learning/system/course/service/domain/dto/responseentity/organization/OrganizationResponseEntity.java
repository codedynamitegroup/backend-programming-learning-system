package com.backend.programming.learning.system.course.service.domain.dto.responseentity.organization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class OrganizationResponseEntity {
    private final UUID organizationId;
    private final String name;
    private final String description;
    private final String apiKey;
    private final String moodleUrl;
}
