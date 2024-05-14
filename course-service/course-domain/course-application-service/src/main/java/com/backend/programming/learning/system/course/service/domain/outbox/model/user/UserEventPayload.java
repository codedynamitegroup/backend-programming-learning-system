package com.backend.programming.learning.system.course.service.domain.outbox.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class UserEventPayload {
    @JsonProperty
    private String id;
    @JsonProperty
    private String userName;
    @JsonProperty
    private String organizationId;

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
    private List<String> failureMessages;
}
