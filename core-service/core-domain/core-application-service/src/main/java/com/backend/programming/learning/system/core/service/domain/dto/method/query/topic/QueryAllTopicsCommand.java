package com.backend.programming.learning.system.core.service.domain.dto.method.query.topic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllTopicsCommand {
    @NotNull
    private final int pageNo;
    @NotNull
    private final int pageSize;
    private final Boolean fetchAll;
}
