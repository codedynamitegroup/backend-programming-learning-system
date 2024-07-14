package com.backend.programming.learning.system.course.service.domain.dto.method.query.synchronize_state;

import com.backend.programming.learning.system.course.service.domain.valueobject.Type;
import com.backend.programming.learning.system.dataaccess.validator.EnumValidator;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStatus;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStep;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QuerySynchronizeStateResponse {
    private final UUID id;
    @NotNull(message = "Status is required")
    @EnumValidator(enumClass = SynchronizeStatus.class, message = "Status is invalid")
    private final String status;

    @NotNull(message = "Step is required")
    @EnumValidator(enumClass = SynchronizeStep.class, message = "Step is invalid")

    private final String step;
    private final Integer syncCount;
}
