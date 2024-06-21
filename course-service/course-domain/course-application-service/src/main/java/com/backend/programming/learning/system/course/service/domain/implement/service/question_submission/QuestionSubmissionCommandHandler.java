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
    private final QuestionSubmissionQueryHelper questionSubmissionQueryHelper;
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

    @Transactional
    public ExamQuestionSubmissionResponse submitExamQuestion(ExamQuestionSubmissionCommand examQuestionSubmissionCommand) {
        questionSubmissionCreateHelper.submitExamQuestion(examQuestionSubmissionCommand);
        return questionSubmissionDataMapper.questionSubmissionsToExamQuestionSubmissionResponse();
    }

    @Transactional
    public OneExamQuestionSubmissionResponse submitOneExamQuestion(OneExamQuestionSubmissionCommand oneExamQuestionSubmissionCommand) {
        QuestionSubmission questionSubmission = questionSubmissionCreateHelper.submitOneExamQuestion(oneExamQuestionSubmissionCommand);

        return questionSubmissionDataMapper.questionSubmissionToOneExamQuestionSubmissionResponse(questionSubmission);
    }

    @Transactional(readOnly = true)
    public QueryQuestionSubmissionResponse getQuestionSubmissionByQuestionIdList(QueryQuestionSubmissionCommand queryQuestionSubmissionCommand) {
        List<QuestionSubmission> questionSubmissionList = questionSubmissionQueryHelper.getQuestionSubmissionByQuestionIdList(queryQuestionSubmissionCommand);

        return questionSubmissionDataMapper.questionSubmissionsToQueryQuestionSubmissionResponse(questionSubmissionList);
    }
}
