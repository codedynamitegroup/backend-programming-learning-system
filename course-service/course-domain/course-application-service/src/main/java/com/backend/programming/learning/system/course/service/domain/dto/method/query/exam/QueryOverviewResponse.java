package com.backend.programming.learning.system.course.service.domain.dto.method.query.exam;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.exam.ExamResponseEntity;
import lombok.Builder;

import java.util.List;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.method.query.exam
 * Create by Dang Ngoc Tien
 * Date 6/1/2024 - 4:01 AM
 * Description: ...
 */
@Builder
public record QueryOverviewResponse(
        List<ExamSubmissionResponse> examSubmissionResponse,
        Integer numberOfStudents,
        Integer submitted,
        Integer needGrading
) {
}
