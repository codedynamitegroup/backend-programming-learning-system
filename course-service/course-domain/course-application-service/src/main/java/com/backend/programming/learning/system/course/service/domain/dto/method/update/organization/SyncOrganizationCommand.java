package com.backend.programming.learning.system.course.service.domain.dto.method.update.organization;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class SyncOrganizationCommand {
    @NotNull
    @Pattern(
            regexp = "^[a-fA-F0-9]{32}$",
            message = "Invalid API key"
    )
    private final String apiKey;

    @NotNull
    @Pattern(
            regexp = "^(http(s)?://)?(([0-9]{1,3}\\.){3}[0-9]{1,3}|([a-zA-Z0-9\\-]+\\.)+[a-zA-Z]{2,})(:[0-9]{1,5})?(/.*)?$",
            message = "Invalid URL"
    )
    private final String moodleUrl;
}
