package com.backend.programming.learning.system.core.service.domain.dto.method.query.contest;

import com.backend.programming.learning.system.core.service.domain.valueobject.ContestStartTimeFilter;
import com.backend.programming.learning.system.dataaccess.validator.EnumValidator;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllMyContestsCommand {
    @NotNull
    private final int pageNo;
    @NotNull
    private final int pageSize;
    @NotNull
    private final String searchName;
    private final String email;
}
