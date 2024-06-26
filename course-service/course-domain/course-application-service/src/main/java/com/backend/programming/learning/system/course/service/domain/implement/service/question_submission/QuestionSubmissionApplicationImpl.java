package com.backend.programming.learning.system.course.service.domain.implement.service.question_submission;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.ExamQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.ExamQuestionSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.OneExamQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.OneExamQuestionSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.CreateQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.CreateQuestionSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.MarkQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.question_submission.QueryQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.question_submission.QueryQuestionSubmissionResponse;
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

    @Override
    public ExamQuestionSubmissionResponse submitExamQuestion(ExamQuestionSubmissionCommand examQuestionSubmissionCommand) {
        return questionSubmissionCommandHandler.submitExamQuestion(examQuestionSubmissionCommand);
    }

    @Override
    public OneExamQuestionSubmissionResponse submitOneExamQuestion(OneExamQuestionSubmissionCommand oneExamQuestionSubmissionCommand) {
        return questionSubmissionCommandHandler.submitOneExamQuestion(oneExamQuestionSubmissionCommand);
    }

    @Override
    public QueryQuestionSubmissionResponse getQuestionSubmissionByQuestionIdList(QueryQuestionSubmissionCommand queryQuestionSubmissionCommand) {
        return questionSubmissionCommandHandler.getQuestionSubmissionByQuestionIdList(queryQuestionSubmissionCommand);
    }
}
