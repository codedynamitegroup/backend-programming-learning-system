package com.backend.programming.learning.system.course.service.domain.implement.exam_question;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.CreateExamQuestionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.CreateExamQuestionResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.exam_question.ExamQuestionApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * com.backend.programming.learning.system.implement.exam_question
 * Create by Dang Ngoc Tien
 * Date 4/21/2024 - 1:56 AM
 * Description: ...
 */
@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class ExamQuestionApplicationServiceImpl implements ExamQuestionApplicationService {
    private final ExamQuestionCommandHandler examQuestionCommandHandler;
    @Override
    public CreateExamQuestionResponse assignExamToQuestions(CreateExamQuestionCommand createExamQuestionCommand) {
        return examQuestionCommandHandler.assignExamToQuestions(createExamQuestionCommand);
    }

    @Override
    public CreateExamQuestionResponse unAssignExamToQuestions(CreateExamQuestionCommand createExamQuestionCommand) {
        return examQuestionCommandHandler.unAssignExamToQuestions(createExamQuestionCommand);
    }
}
