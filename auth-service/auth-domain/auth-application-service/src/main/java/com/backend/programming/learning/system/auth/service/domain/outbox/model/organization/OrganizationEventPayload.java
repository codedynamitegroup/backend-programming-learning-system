package com.backend.programming.learning.system.auth.service.domain.outbox.model.organization;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@Builder
@AllArgsConstructor
public class OrganizationEventPayload {
    @JsonProperty
    private String organizationId;
    @JsonProperty
    private String email;
    @JsonProperty
    private String description;
    @JsonProperty
    private String name;
    @JsonProperty
    private String phone;
    @JsonProperty
    private String address;
    @JsonProperty
    private String apiKey;
    @JsonProperty
    private String moodleUrl;
    @JsonProperty
    private ZonedDateTime createdAt;
    @JsonProperty
    private String createdBy;
    @JsonProperty
    private ZonedDateTime updatedAt;
    @JsonProperty
    private String updatedBy;
    @JsonProperty
    private Boolean isDeleted;
    @JsonProperty
    private String copyState;
}
