package com.backend.programming.learning.system.core.service.domain.dto.method.query.topic;

import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record QueryAllProgrammingLanguageCommand(List<UUID> selectedProgrammingLanguageIds) { }
