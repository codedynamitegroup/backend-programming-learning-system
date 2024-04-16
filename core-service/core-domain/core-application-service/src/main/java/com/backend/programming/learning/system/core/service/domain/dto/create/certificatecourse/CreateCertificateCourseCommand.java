package com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.valueobject.SkillLevel;
import com.backend.programming.learning.system.dataaccess.validator.EnumValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateCertificateCourseCommand {
    @NotNull
    private final String name;

    @EnumValidator(enumClass = SkillLevel.class)
    private final String skillLevel;

    @NotNull
    private final UUID topicId;

    @NotNull
    private final ZonedDateTime startTime;
    private final ZonedDateTime endTime;

    @NotNull
    private final UUID createdBy;
    @NotNull
    private final UUID updatedBy;
}
