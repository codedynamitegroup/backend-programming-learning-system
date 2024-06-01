package com.backend.programming.learning.system.course.service.domain.ports.input.service.exam_question;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.CreateExamQuestionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.CreateExamQuestionResponse;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_question.QueryAllQuestionByExamIdCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_question.QueryAllQuestionByExamIdResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_question.QueryAllQuestionByExamIdWithPageAttResponse;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import jakarta.validation.Valid;

/**
 * com.backend.programming.learning.system.ports.input.service.exam_question
 * Create by Dang Ngoc Tien
 * Date 4/21/2024 - 1:54 AM
 * Description: ...
 */
public interface ExamQuestionApplicationService {
    CreateExamQuestionResponse assignExamToQuestions(
            @Valid CreateExamQuestionCommand createExamQuestionCommand);

    CreateExamQuestionResponse unAssignExamToQuestions(
            @Valid CreateExamQuestionCommand createExamQuestionCommand);

    QueryAllQuestionByExamIdWithPageAttResponse findAllQuestionByExamId(
            ExamId examId,
            @Valid QueryAllQuestionByExamIdCommand queryAllQuestionByExamIdCommand);
}
