package com.backend.programming.learning.system.course.service.domain.dto.responseentity.module;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class ModuleResponseEntity {
    private final UUID moduleId;
    private final UUID assignmentId;
    private final String name;
    private final Integer visible;
    private final String typeModule;
    private final String content;
}
