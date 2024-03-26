package com.backend.programming.learning.system.course.service.domain.mapper.question;

import com.backend.programming.learning.system.course.service.domain.dto.question.create.CreateQuestionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.question.create.CreateQuestionResponse;
import com.backend.programming.learning.system.course.service.domain.entity.question.Question;
import com.backend.programming.learning.system.course.service.domain.event.question.QuestionCreateEvent;
import org.springframework.stereotype.Component;

/**
 * com.backend.programming.learning.system.course.service.domain.mapper.question
 * Create by Dang Ngoc Tien
 * Date 3/25/2024 - 11:57 PM
 * Description: ...
 */
@Component
public class QuestionDataMapper {
    public Question createQuestionToQuestion(CreateQuestionCommand createQuestionCommand) {
        return Question.builder()
                .orgId(createQuestionCommand.getOrgId())
                .name(createQuestionCommand.getName())
                .questionText(createQuestionCommand.getQuestionText())
                .generalFeedback(createQuestionCommand.getGeneralFeedback())
                .defaultMark(createQuestionCommand.getDefaultMark())
                .createdBy(createQuestionCommand.getCreatedBy())
                .updatedBy(createQuestionCommand.getUpdatedBy())
                .qtype(createQuestionCommand.getQtype())
                .difficulty(createQuestionCommand.getDifficulty())
                .build();
    }

    public CreateQuestionResponse mapQuestionCreateEventToCreateQuestionResponse(QuestionCreateEvent questionCreateEvent, String message) {
        return CreateQuestionResponse.builder()
                .question(questionCreateEvent.getQuestion())
                .message(message)
                .build();
    }
}
