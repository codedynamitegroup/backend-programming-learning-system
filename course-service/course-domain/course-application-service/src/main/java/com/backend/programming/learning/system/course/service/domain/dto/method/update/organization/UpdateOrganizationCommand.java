package com.backend.programming.learning.system.course.service.domain.dto.method.update.organization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateOrganizationCommand {
    private final UUID organizationId;
    @NotNull
    private final String description;

    @NotNull
    private final String name;

    @NotNull
    private final String apiKey;

    @NotNull
    private final String moodleUrl;

}
