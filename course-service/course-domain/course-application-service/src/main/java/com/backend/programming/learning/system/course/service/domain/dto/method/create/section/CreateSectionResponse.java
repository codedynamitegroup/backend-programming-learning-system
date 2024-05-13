package com.backend.programming.learning.system.course.service.domain.dto.method.create.section;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateSectionResponse {
    private UUID courseId;
    private UUID sectionId;

    private String name;
    private String message;
}
