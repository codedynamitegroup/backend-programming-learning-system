package com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_grade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@Builder
@AllArgsConstructor
public class UpdateSubmissionGradeCommand {
    private Float grade;
    private ZonedDateTime timemodified;
}
