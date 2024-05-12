package com.backend.programming.learning.system.course.service.domain.dto.method.update.module;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;
@Getter
@Builder
@AllArgsConstructor
public class UpdateModuleResponse {
    private UUID sectionId;
    private String name;
    private Integer visible;
    private ZonedDateTime timeClose;

    private String message;

}
