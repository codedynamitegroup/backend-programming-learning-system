package com.backend.programming.learning.system.course.service.domain.dto.method.create.module;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;
@Getter
@Builder
@AllArgsConstructor
public class CreateModuleCommand {
    private UUID sectionId;
    @NotNull(message = "Module name is required")
    private String name;
    private Integer visible;
    private ZonedDateTime timeOpen;
    private ZonedDateTime timeClose;
}
