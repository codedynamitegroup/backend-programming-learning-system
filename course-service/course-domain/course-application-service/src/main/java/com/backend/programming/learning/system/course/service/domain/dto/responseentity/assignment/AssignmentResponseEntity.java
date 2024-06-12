package com.backend.programming.learning.system.course.service.domain.dto.responseentity.assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class AssignmentResponseEntity {
    private final UUID id;
    private final String title;
    private final String intro;
    private final ZonedDateTime timeClose;
}
