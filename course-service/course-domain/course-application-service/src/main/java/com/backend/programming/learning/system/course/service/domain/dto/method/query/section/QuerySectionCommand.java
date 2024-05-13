package com.backend.programming.learning.system.course.service.domain.dto.method.query.section;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QuerySectionCommand {
    @NotNull
   private final UUID courseId;
}
