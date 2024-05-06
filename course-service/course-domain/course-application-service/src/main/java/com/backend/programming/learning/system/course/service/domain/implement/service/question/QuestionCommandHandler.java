package com.backend.programming.learning.system.course.service.domain.implement.service.question;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.question.CreateQuestionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.question.DeleteQuestionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.question.QueryAllQuestionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.question.QueryAllQuestionExamCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.question.QueryAllQuestionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.question.QueryQuestionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.question.QuestionResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Question;
import com.backend.programming.learning.system.course.service.domain.mapper.question.QuestionDataMapper;
import org.springframework.data.domain.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
    private final QuestionDeleteHelper questionDeleteHelper;
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

    @Transactional
    public void deleteById(DeleteQuestionCommand deleteQuestionCommand) {
        questionDeleteHelper.deleteById(deleteQuestionCommand);
    }

    @Transactional
    public CreateQuestionResponse createQuestionBank(CreateQuestionCommand createQuestionCommand) {
        Question question = questionCreateHelper.createQuestionBank(createQuestionCommand);
        log.info("Question bank is created with id: {}", question.getId());
        return questionDataMapper.questionToCreateQuestionResponse(question, "Question bank created successfully");
    }

    public QueryAllQuestionResponse findAllQuestionsByExamId(QueryAllQuestionExamCommand queryAllQuestionCommand) {
        Page<Question> questions = questionQueryHelper.findAllQuestionsByExamId(queryAllQuestionCommand);
        return questionDataMapper.questionsToQueryAllQuestionResponse(questions);
    }
}
