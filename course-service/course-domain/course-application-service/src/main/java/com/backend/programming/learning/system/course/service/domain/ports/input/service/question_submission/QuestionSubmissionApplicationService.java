package com.backend.programming.learning.system.course.service.domain.ports.input.service.question_submission;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.CreateQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.CreateQuestionSubmissionResponse;

import javax.validation.Valid;

/**
 * com.backend.programming.learning.system.ports.input.service.question_submission
 * Create by Dang Ngoc Tien
 * Date 4/24/2024 - 1:25 AM
 * Description: ...
 */
public interface QuestionSubmissionApplicationService {
    CreateQuestionSubmissionResponse submitQuestion(
            @Valid CreateQuestionSubmissionCommand createQuestionSubmissionCommand);
}
