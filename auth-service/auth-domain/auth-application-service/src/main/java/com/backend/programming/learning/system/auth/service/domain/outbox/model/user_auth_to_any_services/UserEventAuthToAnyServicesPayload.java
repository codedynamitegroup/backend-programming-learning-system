package com.backend.programming.learning.system.auth.service.domain.outbox.model.user_auth_to_any_services;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@Builder
@AllArgsConstructor
public class UserEventAuthToAnyServicesPayload {
    @JsonProperty
    private String userId;
    @JsonProperty
    private String email;
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
    @JsonProperty
    private String phone;
    @JsonProperty
    private String address;
    @JsonProperty
    private String avatarUrl;
    @JsonProperty
    private ZonedDateTime dob;
    @JsonProperty
    private ZonedDateTime createdAt;
    @JsonProperty
    private ZonedDateTime updatedAt;
    @JsonProperty
    private Boolean isDeleted;
    @JsonProperty
    private String copyState;
}
