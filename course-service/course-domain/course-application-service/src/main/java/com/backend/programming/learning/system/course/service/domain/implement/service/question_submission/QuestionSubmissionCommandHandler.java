package com.backend.programming.learning.system.course.service.domain.implement.service.question_submission;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.CreateQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.CreateQuestionSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.MarkQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionSubmission;
import com.backend.programming.learning.system.course.service.domain.mapper.question_submission.QuestionSubmissionDataMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional
    public CreateQuestionSubmissionResponse submitQuestion(CreateQuestionSubmissionCommand createQuestionSubmissionCommand) {
        QuestionSubmission questionSubmission = questionSubmissionCreateHelper.createQuestionSubmission(createQuestionSubmissionCommand);
        return questionSubmissionDataMapper.mapToCreateQuestionSubmissionResponse(questionSubmission);
    }

    @Transactional
    public void markQuestion(List<MarkQuestionSubmissionCommand> markQuestionSubmissionCommandList) {
        questionSubmissionCreateHelper.markQuestion(markQuestionSubmissionCommandList);
    }
}
