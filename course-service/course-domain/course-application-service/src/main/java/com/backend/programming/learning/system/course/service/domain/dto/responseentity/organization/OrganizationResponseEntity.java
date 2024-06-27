package com.backend.programming.learning.system.course.service.domain.dto.responseentity.organization;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Builder
@Setter
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class OrganizationResponseEntity {
    private UUID organizationId;
    private String name;
    private String description;
    private String apiKey;
    private String moodleUrl;
}
