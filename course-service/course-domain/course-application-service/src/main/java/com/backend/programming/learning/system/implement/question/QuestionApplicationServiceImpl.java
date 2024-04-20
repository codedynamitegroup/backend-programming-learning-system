package com.backend.programming.learning.system.implement.question;

import com.backend.programming.learning.system.dto.method.create.question.CreateQuestionCommand;
import com.backend.programming.learning.system.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.dto.method.delete.question.DeleteQuestionCommand;
import com.backend.programming.learning.system.dto.method.query.question.QueryAllQuestionCommand;
import com.backend.programming.learning.system.dto.method.query.question.QueryAllQuestionResponse;
import com.backend.programming.learning.system.dto.method.query.question.QueryQuestionCommand;
import com.backend.programming.learning.system.dto.responseentity.question.QuestionResponseEntity;
import com.backend.programming.learning.system.ports.input.service.question.QuestionApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.implemtent.question
 * Create by Dang Ngoc Tien
 * Date 4/17/2024 - 11:01 PM
 * Description: ...
 */
@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class QuestionApplicationServiceImpl implements QuestionApplicationService {
    private final QuestionCommandHandler questionCommandHandler;

    @Override
    public CreateQuestionResponse createQuestion(CreateQuestionCommand createQuestionCommand) {
        return questionCommandHandler.createQuestion(createQuestionCommand);
    }

    @Override
    public QueryAllQuestionResponse findAllQuestions(QueryAllQuestionCommand queryAllQuestionCommand) {
        return questionCommandHandler.findAllQuestions(queryAllQuestionCommand);
    }

    @Override
    public QuestionResponseEntity findById(QueryQuestionCommand queryQuestionCommand) {
        return questionCommandHandler.findById(queryQuestionCommand);
    }

    @Override
    public void deleteById(DeleteQuestionCommand deleteQuestionCommand) {
        questionCommandHandler.deleteById(deleteQuestionCommand);
    }
}
