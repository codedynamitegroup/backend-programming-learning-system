package com.backend.programming.learning.system.course.service.domain.dto.responseentity.section;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class SectionResponseEntity {
    private final UUID sectionId;
    private final String name;
    private final Integer visible;
}
