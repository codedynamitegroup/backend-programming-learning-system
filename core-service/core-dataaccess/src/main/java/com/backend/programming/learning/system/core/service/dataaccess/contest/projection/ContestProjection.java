package com.backend.programming.learning.system.core.service.dataaccess.contest.projection;

import java.time.Instant;
import java.util.UUID;


public interface ContestProjection {
    UUID getId();
    String getName();
    String getDescription();
    String getPrizes();
    String getRules();
    String getScoring();
    String getThumbnailUrl();
    Instant getStartTime();
    Instant getEndTime();
    Boolean getIsPublic();
    UUID getCreatedById();
    UUID getUpdatedById();
    Instant getCreatedAt();
    Instant getUpdatedAt();
    Integer getNumOfParticipants();
}
