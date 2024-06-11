package com.backend.programming.learning.system.course.service.domain.implement.service.question_submission;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.CreateQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.CreateQuestionSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.MarkQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.question_submission.QuestionSubmissionApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * com.backend.programming.learning.system.implement.question_submission
 * Create by Dang Ngoc Tien
 * Date 4/24/2024 - 1:22 AM
 * Description: ...
 */
@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class QuestionSubmissionApplicationImpl implements QuestionSubmissionApplicationService {
    private final QuestionSubmissionCommandHandler questionSubmissionCommandHandler;
    @Override
    public CreateQuestionSubmissionResponse submitQuestion(CreateQuestionSubmissionCommand createQuestionSubmissionCommand) {
        return questionSubmissionCommandHandler.submitQuestion(createQuestionSubmissionCommand);
    }

    @Override
    public void markQuestion(List<MarkQuestionSubmissionCommand> markQuestionSubmissionCommandList) {
        questionSubmissionCommandHandler.markQuestion(markQuestionSubmissionCommandList);
    }
}
