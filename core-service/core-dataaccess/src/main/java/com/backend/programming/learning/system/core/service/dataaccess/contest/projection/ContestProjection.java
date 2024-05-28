package com.backend.programming.learning.system.core.service.dataaccess.contest.projection;

import java.time.Instant;
import java.util.UUID;


public interface ContestProjection {
    UUID getId();
    String getName();
    String getDescription();
    String getThumbnailUrl();
    Instant getStartTime();
    Instant getEndTime();
    UUID getCreatedById();
    UUID getUpdatedById();
    Instant getCreatedAt();
    Instant getUpdatedAt();
    Integer getNumOfParticipants();
}
