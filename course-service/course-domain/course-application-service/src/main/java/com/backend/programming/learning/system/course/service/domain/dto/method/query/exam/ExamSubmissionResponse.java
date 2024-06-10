package com.backend.programming.learning.system.course.service.domain.dto.method.query.exam;

import com.backend.programming.learning.system.course.service.domain.valueobject.Status;
import lombok.Builder;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.method.query.exam
 * Create by Dang Ngoc Tien
 * Date 6/7/2024 - 12:44 PM
 * Description: ...
 */
@Builder
public record ExamSubmissionResponse(
        UUID examSubmissionId,
        UUID studentId,
        String firstName,
        String lastName,
        ZonedDateTime startTime,
        ZonedDateTime submitTime,
        Status status
) {
}
