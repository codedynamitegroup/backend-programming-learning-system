package com.backend.programming.learning.system.implement.question;

import com.backend.programming.learning.system.dto.method.create.question.CreateQuestionCommand;
import com.backend.programming.learning.system.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.dto.method.query.question.QueryAllQuestionCommand;
import com.backend.programming.learning.system.dto.method.query.question.QueryAllQuestionResponse;
import com.backend.programming.learning.system.dto.method.query.question.QueryQuestionCommand;
import com.backend.programming.learning.system.dto.responseentity.question.QuestionResponseEntity;
import com.backend.programming.learning.system.entity.Question;
import com.backend.programming.learning.system.mapper.question.QuestionDataMapper;
import org.springframework.data.domain.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.implement.question
 * Create by Dang Ngoc Tien
 * Date 4/17/2024 - 11:44 PM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class QuestionCommandHandler {
    private final QuestionCreateHelper questionCreateHelper;
    private final QuestionQueryHelper questionQueryHelper;
    private final QuestionDataMapper questionDataMapper;

    @Transactional
    public CreateQuestionResponse createQuestion(CreateQuestionCommand createQuestionCommand) {
        Question question = questionCreateHelper.createQuestion(createQuestionCommand);
        log.info("Question is created with id: {}", question.getId());
        return questionDataMapper.questionToCreateQuestionResponse(question, "Question created successfully");
    }

    @Transactional(readOnly = true)
    public QueryAllQuestionResponse findAllQuestions(QueryAllQuestionCommand queryAllQuestionCommand) {
        Page<Question> questions = questionQueryHelper.findAllQuestions(queryAllQuestionCommand);
        return questionDataMapper.questionsToQueryAllQuestionResponse(questions);
    }

    @Transactional(readOnly = true)
    public QuestionResponseEntity findById(QueryQuestionCommand queryQuestionCommand) {
        Question question = questionQueryHelper.findById(queryQuestionCommand.getQuestionId());
        return questionDataMapper.questionToQueryQuestionResponse(question);
    }
}
