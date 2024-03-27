package com.backend.programming.learning.system.course.service.domain.service.question;

import com.backend.programming.learning.system.course.service.domain.dto.question.create.CreateQuestionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.question.create.CreateQuestionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.question.get.QuestionResponse;
import com.backend.programming.learning.system.course.service.domain.entity.question.Question;
import com.backend.programming.learning.system.course.service.domain.event.question.QuestionCreateEvent;
import com.backend.programming.learning.system.course.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.question.QuestionApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * com.backend.programming.learning.system.course.service.domain.service
 * Create by Dang Ngoc Tien
 * Date 3/25/2024 - 11:12 PM
 * Description: ...
 */
@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class QuestionApplicationServiceImpl implements QuestionApplicationService {
    private final QuestionCreateCommandHandler questionCreateCommandHandler;
    private final QuestionDataMapper questionDataMapper;
    @Override
    public CreateQuestionResponse createQuestion(Long examId, CreateQuestionCommand createQuestionCommand) {
        QuestionCreateEvent questionCreateEvent = questionCreateCommandHandler.createQuestion(examId, createQuestionCommand);
        return questionDataMapper.mapQuestionCreateEventToCreateQuestionResponse(questionCreateEvent, "Question created successfully");
    }

    @Override
    public QuestionResponse getQuestions(Long examId) {
        List<Question> question = questionCreateCommandHandler.getQuestions(examId);
        return questionDataMapper.mapQuestionToCreateQuestionResponse(question, "Question created successfully");
    }

    @Override
    public void deleteQuestion(Long examId, Long questionId) {
        questionCreateCommandHandler.deleteQuestion(examId, questionId);
    }

    @Override
    public CreateQuestionResponse getQuestion(Long questionId) {
        Question question = questionCreateCommandHandler.getQuestion(questionId);
        return questionDataMapper.mapQuestionToCreateQuestionResponse(question, "Question created successfully");
    }

    @Override
    public CreateQuestionResponse updateQuestion(Long examId, Long questionId, CreateQuestionCommand createQuestionCommand) {
        QuestionCreateEvent questionCreateEvent = questionCreateCommandHandler.updateQuestion(examId, questionId, createQuestionCommand);
        return questionDataMapper.mapQuestionCreateEventToCreateQuestionResponse(questionCreateEvent, "Question updated successfully");
    }
}
