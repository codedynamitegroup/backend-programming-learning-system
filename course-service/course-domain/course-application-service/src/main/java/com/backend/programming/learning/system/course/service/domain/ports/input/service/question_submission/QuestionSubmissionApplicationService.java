package com.backend.programming.learning.system.course.service.domain.ports.input.service.question_submission;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.ExamQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.ExamQuestionSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.OneExamQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.OneExamQuestionSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.CreateQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.CreateQuestionSubmissionResponse;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.MarkQuestionSubmissionCommand;
import jakarta.validation.Valid;

import java.util.List;

/**
 * com.backend.programming.learning.system.ports.input.service.question_submission
 * Create by Dang Ngoc Tien
 * Date 4/24/2024 - 1:25 AM
 * Description: ...
 */
public interface QuestionSubmissionApplicationService {
    CreateQuestionSubmissionResponse submitQuestion(
            @Valid CreateQuestionSubmissionCommand createQuestionSubmissionCommand);

    void markQuestion(
            @Valid List<MarkQuestionSubmissionCommand> markQuestionSubmissionCommandList);

    ExamQuestionSubmissionResponse submitExamQuestion(ExamQuestionSubmissionCommand examQuestionSubmissionCommand);

    OneExamQuestionSubmissionResponse submitOneExamQuestion(OneExamQuestionSubmissionCommand oneExamQuestionSubmissionCommand);
}
