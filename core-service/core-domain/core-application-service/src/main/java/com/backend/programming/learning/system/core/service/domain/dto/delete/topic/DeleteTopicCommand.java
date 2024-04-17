package com.backend.programming.learning.system.core.service.domain.dto.delete.topic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteTopicCommand {
    @NotNull(message = "topicId is required")
    private final UUID topicId;
}
