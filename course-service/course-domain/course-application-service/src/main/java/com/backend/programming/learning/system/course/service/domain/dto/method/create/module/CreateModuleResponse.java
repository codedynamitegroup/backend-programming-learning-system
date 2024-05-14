package com.backend.programming.learning.system.course.service.domain.dto.method.create.module;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;
@Getter
@Builder
@AllArgsConstructor
public class CreateModuleResponse {
    private UUID sectionId;
    private String name;
    private Integer visible;

    private String message;

}
