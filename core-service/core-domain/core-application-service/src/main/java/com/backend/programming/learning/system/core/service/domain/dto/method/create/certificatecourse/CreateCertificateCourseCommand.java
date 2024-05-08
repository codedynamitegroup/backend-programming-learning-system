package com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.validator.certificatecourse.CreateCertificateCourseCommandStartTimeAndEndTimeValidator;
import com.backend.programming.learning.system.core.service.domain.valueobject.SkillLevel;
import com.backend.programming.learning.system.dataaccess.validator.EnumValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@CreateCertificateCourseCommandStartTimeAndEndTimeValidator
public class CreateCertificateCourseCommand {
    @NotNull(message = "Name is required")
    private final String name;

    @NotNull(message = "Description is required")
    private final String description;

    @NotNull(message = "SkillLevel is required")
    @EnumValidator(enumClass = SkillLevel.class, message = "SkillLevel is invalid")
    private final String skillLevel;

    @NotNull(message = "TopicId is required")
    private final UUID topicId;

    @NotNull(message = "StartTime is required")
    private final ZonedDateTime startTime;
    private final ZonedDateTime endTime;

    @NotNull(message = "CreatedBy is required")
    private final UUID createdBy;
    @NotNull(message = "UpdatedBy is required")
    private final UUID updatedBy;
}
