package com.backend.programming.learning.system.core.service.dataaccess.contest_user.projection;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

public interface ContestUserLeaderboardProjection {
    UUID getId();
    UUID getUserId();
    UUID getContestId();
    UUID getCalendarEventId();
    String getUpdateCalendarEventState();
    Boolean getIsCompleted();
    Instant getCompletedAt();
    Instant getCreatedAt();
    Instant getUpdatedAt();
    Integer getRank();
    Float getTotalScore();
    Long getTotalTime();
}
