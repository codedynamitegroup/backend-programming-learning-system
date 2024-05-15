package com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllCertificateCoursesFilterByIsRegisteredCommand {
    @NotNull(message = "Course name is required")
    private final String courseName;
    private final List<UUID> filterTopicIds;
    @NotNull(message = "Is registered is required")
    private final boolean isRegistered;
    private final String username;
}
