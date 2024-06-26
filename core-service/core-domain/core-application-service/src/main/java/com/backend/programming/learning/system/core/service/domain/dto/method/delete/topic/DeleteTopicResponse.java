package com.backend.programming.learning.system.core.service.domain.dto.method.delete.topic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteTopicResponse {
    @NotNull
    private final UUID topicId;
    @NotNull
    private final String message;
}
