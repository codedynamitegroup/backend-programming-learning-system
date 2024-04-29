package com.backend.programming.learning.system.core.service.domain.outbox.model.contest_user;

import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@Builder
@AllArgsConstructor
public class ContestUserUpdateEventPayload {
    @JsonProperty
    private ContestUser contestUser;
    @JsonProperty
    private String updateCalendarEventState;
    @JsonProperty
    private ZonedDateTime createdAt;
}
