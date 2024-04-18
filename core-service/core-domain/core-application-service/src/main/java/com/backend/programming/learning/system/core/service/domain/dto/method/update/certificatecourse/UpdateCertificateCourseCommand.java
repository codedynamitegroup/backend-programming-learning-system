package com.backend.programming.learning.system.core.service.domain.dto.method.update.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.validator.certificatecourse.UpdateCertificateCourseCommandStartTimeAndEndTimeValidator;
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
@UpdateCertificateCourseCommandStartTimeAndEndTimeValidator
public class UpdateCertificateCourseCommand {
    private final UUID certificateCourseId;
    private final String name;
    private final String description;
    @EnumValidator(enumClass = SkillLevel.class, message = "SkillLevel is invalid")
    private final String skillLevel;
    private final UUID topicId;
    private final ZonedDateTime startTime;
    private final ZonedDateTime endTime;
    @NotNull
    private final UUID updatedBy;
}
