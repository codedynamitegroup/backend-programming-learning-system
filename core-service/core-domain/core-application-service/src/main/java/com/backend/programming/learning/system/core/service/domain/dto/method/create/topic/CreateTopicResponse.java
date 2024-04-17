package com.backend.programming.learning.system.core.service.domain.dto.method.create.topic;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateTopicResponse {
    @NotNull
    private final UUID topicId;
    @NotNull
    private final String message;
}
