package com.backend.programming.learning.system.course.service.domain.dto.method.query.synchronize_state_detail;

import com.backend.programming.learning.system.dataaccess.validator.EnumValidator;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStatus;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStep;
import com.backend.programming.learning.system.domain.valueobject.TypeSynchronize;
import com.backend.programming.learning.system.domain.valueobject.TypeSynchronizeStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QuerySynchronizeStateDetailResponse {
    private final UUID id;
    @NotNull(message = "Status is required")
    @EnumValidator(enumClass = TypeSynchronizeStatus.class, message = "Status is invalid")
    private final String status;

    private String webhookMessage;

    @NotNull(message = "Type synchronize is required")
    @EnumValidator(enumClass = TypeSynchronize.class, message = "Type synchronize is invalid")
    private final String typeSynchronize;
}
