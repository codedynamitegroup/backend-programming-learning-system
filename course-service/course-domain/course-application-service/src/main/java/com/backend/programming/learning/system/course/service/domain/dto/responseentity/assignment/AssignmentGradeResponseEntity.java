package com.backend.programming.learning.system.course.service.domain.dto.responseentity.assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class AssignmentGradeResponseEntity {
    private final UUID id;
    private final String title;
    private final Float grade;
   private final Float maxScore;
   private final String feedback;
   private final String type;
}
