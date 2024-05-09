package com.backend.programming.learning.system.core.service.domain.dto.method.update.topic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateTopicResponse {
    @NotNull
    private final UUID topicId;
    @NotNull
    private final String message;
}
