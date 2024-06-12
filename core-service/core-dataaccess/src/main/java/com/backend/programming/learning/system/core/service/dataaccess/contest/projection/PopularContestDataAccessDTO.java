package com.backend.programming.learning.system.core.service.dataaccess.contest.projection;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.UUID;


public interface PopularContestDataAccessDTO {
         UUID getId();
         String getContestName();
         Integer getTotalSubmissions();
         Integer getTotalParticipants();
         Instant getCreatedAt();
         Instant getUpdatedAt();
         Instant getStartTime();
         Instant getEndTime();
}
