package com.backend.programming.learning.system.auth.service.domain.dto.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Getter
@Builder
@AllArgsConstructor
public class QueryUserRoleResponse {
    @NotNull
    private String name;

    @NotNull
    private ZonedDateTime createdAt;
}
