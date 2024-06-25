package com.backend.programming.learning.system.course.service.domain.dto.method.query.question_submission;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QuestionSubmissionResponse;
import lombok.Builder;

import java.util.List;

@Builder
public record QueryQuestionSubmissionResponse(
        List<QuestionSubmissionResponse> questionSubmissions
) { }
