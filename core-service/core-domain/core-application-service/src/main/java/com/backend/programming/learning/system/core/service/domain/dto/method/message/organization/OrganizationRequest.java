package com.backend.programming.learning.system.core.service.domain.dto.method.message.organization;

import com.backend.programming.learning.system.domain.valueobject.CopyState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
@AllArgsConstructor
public class OrganizationRequest {
    private String id;
    private String sagaId;
    private String organizationId;
    private String description;
    private String name;
    private String apiKey;
    private String moodleUrl;
    private CopyState copyState;
    private Instant createdAt;
    private Instant updatedAt;
    private Boolean isDeleted;
}
