package com.backend.programming.learning.system.course.service.domain.dto.method.query.module;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.module.ModuleResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllModuleResponse {
    private UUID sectionId;
    private List<ModuleResponseEntity> modules;
}
