package com.backend.programming.learning.system.core.service.domain.outbox.model.organization;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class OrganizationEventPayload {
    @JsonProperty
    private String organizationId;
    @JsonProperty
    private String copyState;
    @JsonProperty
    private List<String> failureMessages;
}
