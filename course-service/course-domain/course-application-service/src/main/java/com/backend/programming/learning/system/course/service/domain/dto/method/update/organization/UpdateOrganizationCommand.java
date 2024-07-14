package com.backend.programming.learning.system.course.service.domain.dto.method.update.organization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateOrganizationCommand {
    private final String description;

    private final String name;

    private final String apiKey;

    private final String moodleUrl;


}
