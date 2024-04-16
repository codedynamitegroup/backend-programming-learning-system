package com.backend.programming.learning.system.core.service.domain.dto.query.topic;

import com.backend.programming.learning.system.core.service.domain.dto.query.user.QueryUserResponse;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryTopicResponse {
    @NotNull
    private final UUID topicId;
    @NotNull
    private final String name;
    @NotNull
    private final String description;
    @NotNull
    private final QueryUserResponse createdBy;
    @NotNull
    private final QueryUserResponse updatedBy;
    @NotNull
    private final ZonedDateTime createdAt;
    @NotNull
    private final ZonedDateTime updatedAt;
}
