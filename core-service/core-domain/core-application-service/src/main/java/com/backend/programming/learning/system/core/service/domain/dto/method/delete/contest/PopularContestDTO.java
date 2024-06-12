package com.backend.programming.learning.system.core.service.domain.dto.method.delete.contest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class PopularContestDTO {
    UUID id;
    String contestName;
    Integer totalParticipants;
    Integer totalSubmissions;
    ZonedDateTime createdAt;
    ZonedDateTime updatedAt;
    ZonedDateTime startTime;
    ZonedDateTime endTime;
}
