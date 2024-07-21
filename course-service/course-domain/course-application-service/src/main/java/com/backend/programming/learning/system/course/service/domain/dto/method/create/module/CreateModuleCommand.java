package com.backend.programming.learning.system.course.service.domain.dto.method.create.module;

import com.backend.programming.learning.system.course.service.domain.valueobject.Type;
import com.backend.programming.learning.system.course.service.domain.valueobject.TypeModule;
import com.backend.programming.learning.system.dataaccess.validator.EnumValidator;
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
    private UUID assignmentId;
    private UUID examId;
    private Integer cmid;
    @EnumValidator(enumClass = TypeModule.class, message = "Type is invalid")
    private final String type;
}
