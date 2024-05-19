package com.backend.programming.learning.system.core.service.domain.dto.responseentity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class OrganizationResponseEntity {
    private final String id;
    private final String name;
    private final String description;
    private final String moodleUrl;
    private final String apiKey;
    private final Boolean isDeleted;
    private final ZonedDateTime createdAt;
    private final ZonedDateTime updatedAt;
}
