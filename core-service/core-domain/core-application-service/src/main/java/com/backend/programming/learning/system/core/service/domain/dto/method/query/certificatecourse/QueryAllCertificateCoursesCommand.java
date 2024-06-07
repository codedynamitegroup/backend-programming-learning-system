package com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.valueobject.IsRegisteredFilter;
import com.backend.programming.learning.system.dataaccess.validator.EnumValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllCertificateCoursesCommand {
    @NotNull(message = "Course name is required")
    private final String courseName;
    private final UUID filterTopicId;
    @NotNull(message = "Is registered filter is required")
    @EnumValidator(enumClass = IsRegisteredFilter.class, message = "Is registered filter is invalid")
    private final String isRegisteredFilter;
    private final String email;
}
