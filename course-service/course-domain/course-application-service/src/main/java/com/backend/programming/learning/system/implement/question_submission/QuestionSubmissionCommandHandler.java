package com.backend.programming.learning.system.implement.question_submission;

import com.backend.programming.learning.system.dto.method.create.question_submission.CreateQuestionSubmissionCommand;
import com.backend.programming.learning.system.dto.method.create.question_submission.CreateQuestionSubmissionResponse;
import com.backend.programming.learning.system.entity.QuestionSubmission;
import com.backend.programming.learning.system.mapper.question_submission.QuestionSubmissionDataMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * com.backend.programming.learning.system.implement.question_submission
 * Create by Dang Ngoc Tien
 * Date 4/24/2024 - 1:23 AM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class QuestionSubmissionCommandHandler {
    private final QuestionSubmissionCreateHelper questionSubmissionCreateHelper;
    private final QuestionSubmissionDataMapper questionSubmissionDataMapper;
    public CreateQuestionSubmissionResponse submitQuestion(CreateQuestionSubmissionCommand createQuestionSubmissionCommand) {
        QuestionSubmission questionSubmission = questionSubmissionCreateHelper.createQuestionSubmission(createQuestionSubmissionCommand);
        return questionSubmissionDataMapper.mapToCreateQuestionSubmissionResponse(questionSubmission);
    }
}
