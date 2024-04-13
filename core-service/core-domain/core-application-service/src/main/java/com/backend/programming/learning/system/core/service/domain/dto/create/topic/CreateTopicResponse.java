package com.backend.programming.learning.system.core.service.domain.dto.create.topic;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class CreateTopicResponse {
    @NotNull
    private final Topic topic;
    @NotNull
    private final String message;
}
