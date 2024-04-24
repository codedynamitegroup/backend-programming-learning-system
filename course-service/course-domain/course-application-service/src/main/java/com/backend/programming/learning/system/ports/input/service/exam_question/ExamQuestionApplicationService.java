package com.backend.programming.learning.system.ports.input.service.exam_question;

import com.backend.programming.learning.system.dto.method.create.exam_submisison.exam_question.CreateExamQuestionCommand;
import com.backend.programming.learning.system.dto.method.create.exam_submisison.exam_question.CreateExamQuestionResponse;

import javax.validation.Valid;

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
}
