package com.backend.programming.learning.system.core.service.domain.dto.method.query.topic;

import com.backend.programming.learning.system.core.service.domain.dto.method.query.programminglanguage.QueryProgrammingLanguageResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.user.QueryUserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.List;
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
    private final List<QueryProgrammingLanguageResponse> programmingLanguages;
    @NotNull
    private final QueryUserResponse createdBy;
    @NotNull
    private final QueryUserResponse updatedBy;
    @NotNull
    private final ZonedDateTime createdAt;
    @NotNull
    private final ZonedDateTime updatedAt;
}
