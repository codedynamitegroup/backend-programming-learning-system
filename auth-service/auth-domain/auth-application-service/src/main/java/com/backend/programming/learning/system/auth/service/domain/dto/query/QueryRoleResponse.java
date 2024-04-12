package com.backend.programming.learning.system.auth.service.domain.dto.query;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@Builder
@AllArgsConstructor
public class QueryRoleResponse {
    private String description;
    private String name;

    @NotNull
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}
