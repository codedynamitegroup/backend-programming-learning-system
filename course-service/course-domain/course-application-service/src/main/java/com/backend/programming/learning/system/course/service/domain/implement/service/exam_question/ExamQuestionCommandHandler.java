package com.backend.programming.learning.system.course.service.domain.implement.service.exam_question;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.CreateExamQuestionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.CreateExamQuestionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_question.QueryAllQuestionByExamIdCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_question.QueryAllQuestionByExamIdResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_question.QueryAllQuestionByExamIdWithPageAttResponse;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * com.backend.programming.learning.system.implement.exam_question
 * Create by Dang Ngoc Tien
 * Date 4/21/2024 - 1:56 AM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ExamQuestionCommandHandler {
    private final ExamQuestionCreateHelper examQuestionCreateHelper;
    private final ExamQuestionDeleteHelper examQuestionDeleteHelper;
    @Transactional
    public CreateExamQuestionResponse assignExamToQuestions(CreateExamQuestionCommand createExamQuestionCommand) {
        log.info("Assign exam to question");
        examQuestionCreateHelper.assignExamToQuestions(createExamQuestionCommand);
        return CreateExamQuestionResponse.builder().message("Exam assigned to question").build();
    }

    @Transactional
    public CreateExamQuestionResponse unAssignExamToQuestions(CreateExamQuestionCommand createExamQuestionCommand) {
        log.info("Un-assign exam to question");
        examQuestionDeleteHelper.unAssignExamToQuestions(createExamQuestionCommand);
        return CreateExamQuestionResponse.builder().message("Exam un-assigned to question").build();
    }

    public QueryAllQuestionByExamIdWithPageAttResponse findAllQuestionByExamId(
            ExamId examId, QueryAllQuestionByExamIdCommand queryAllQuestionByExamIdCommand) {
        log.info("Get all question by exam id");
        return examQuestionCreateHelper.findAllQuestionByExamId(examId, queryAllQuestionByExamIdCommand);
    }
}
