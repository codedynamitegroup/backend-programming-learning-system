package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.tag;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor
public class TagResponseItem {
    UUID id;
    String name;
}
