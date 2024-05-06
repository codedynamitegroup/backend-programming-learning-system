package com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class UserEventPayload {
    @JsonProperty
    private String userId;
    @JsonProperty
    private String copyState;
    @JsonProperty
    private List<String> failureMessages;
}
