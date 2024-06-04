package com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_grade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class SubmissionGradeResponseEntity {
    private UUID id;
    private float grade;
    private ZonedDateTime timeCreated;
    private ZonedDateTime timeModified;
}
