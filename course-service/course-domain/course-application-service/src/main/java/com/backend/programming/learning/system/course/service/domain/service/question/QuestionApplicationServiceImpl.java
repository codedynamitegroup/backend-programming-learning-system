package com.backend.programming.learning.system.course.service.domain.service.question;

import com.backend.programming.learning.system.course.service.domain.dto.question.create.CreateQuestionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.question.create.CreateQuestionResponse;
import com.backend.programming.learning.system.course.service.domain.event.question.QuestionCreateEvent;
import com.backend.programming.learning.system.course.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.question.QuestionApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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
    public CreateQuestionResponse createQuestion(CreateQuestionCommand createQuestionCommand) {
        QuestionCreateEvent questionCreateEvent = questionCreateCommandHandler.createQuestion(createQuestionCommand);
        return questionDataMapper.mapQuestionCreateEventToCreateQuestionResponse(questionCreateEvent, "Question created successfully");
    }
}
