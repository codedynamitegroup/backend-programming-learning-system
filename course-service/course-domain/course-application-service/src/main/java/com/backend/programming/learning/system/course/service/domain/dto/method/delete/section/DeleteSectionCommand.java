package com.backend.programming.learning.system.course.service.domain.dto.method.delete.section;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;
@Getter
@Builder
@AllArgsConstructor
public class DeleteSectionCommand {
    private final UUID sectionId;
}
