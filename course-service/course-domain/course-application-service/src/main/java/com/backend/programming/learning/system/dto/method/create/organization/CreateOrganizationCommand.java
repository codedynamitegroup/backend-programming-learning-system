package com.backend.programming.learning.system.dto.method.create.organization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class CreateOrganizationCommand {
    @NotNull
    private final String description;

    @NotNull
    private final String name;

    @NotNull
    private final String apiKey;

    @NotNull
    private final String moodleUrl;
}
