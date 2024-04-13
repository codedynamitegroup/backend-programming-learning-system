package com.backend.programming.learning.system.core.service.domain.dto.query;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class QueryTopicResponse {
    @NotNull
    private final Topic topic;
    @NotNull
    private final String message;
}
