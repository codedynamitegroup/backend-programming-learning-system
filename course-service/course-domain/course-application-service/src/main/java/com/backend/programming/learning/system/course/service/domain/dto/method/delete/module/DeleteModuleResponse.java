package com.backend.programming.learning.system.course.service.domain.dto.method.delete.module;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;
@Getter
@Builder
@AllArgsConstructor
public class DeleteModuleResponse {
   private UUID moduleId;
   private String message;
}
