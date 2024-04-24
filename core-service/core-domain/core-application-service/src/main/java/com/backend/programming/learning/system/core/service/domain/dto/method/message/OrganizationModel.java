package com.backend.programming.learning.system.core.service.domain.dto.method.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class OrganizationModel {
    private String id;
    private String sagaId;
    private String name;
    private String description;
    private String moodle_url;
    private String createdAt;
    private String updatedAt;
}
