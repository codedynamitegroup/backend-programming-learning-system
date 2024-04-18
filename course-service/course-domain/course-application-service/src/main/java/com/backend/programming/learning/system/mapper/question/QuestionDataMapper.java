package com.backend.programming.learning.system.mapper.question;

import com.backend.programming.learning.system.dto.method.create.question.CreateQuestionCommand;
import com.backend.programming.learning.system.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.dto.method.query.question.QueryAllQuestionResponse;
import com.backend.programming.learning.system.dto.responseentity.question.QuestionResponseEntity;
import com.backend.programming.learning.system.entity.Organization;
import com.backend.programming.learning.system.entity.Question;
import com.backend.programming.learning.system.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * com.backend.programming.learning.system.mapper.question
 * Create by Dang Ngoc Tien
 * Date 4/17/2024 - 11:37 PM
 * Description: ...
 */
@Component
public class QuestionDataMapper {
    public Question createQuestionCommandToQuestion(Organization organization,
                                                    User createdBy,
                                                    CreateQuestionCommand createQuestionCommand) {
        return Question.builder()
                .organization(organization)
                .questionText(createQuestionCommand.getQuestionText())
                .difficulty(createQuestionCommand.getDifficulty())
                .name(createQuestionCommand.getName())
                .generalFeedback(createQuestionCommand.getGeneralFeedback())
                .defaultMark(createQuestionCommand.getDefaultMark())
                .qtype(createQuestionCommand.getQtype())
                .createdBy(createdBy)
                .updatedBy(createdBy)
                .build();
    }

    public CreateQuestionResponse questionToCreateQuestionResponse(Question question, String message) {
        return CreateQuestionResponse.builder()
                .questionId(question.getId())
                .organizationId(question.getOrganization().getId())
                .difficulty(question.getDifficulty())
                .name(question.getName())
                .questionText(question.getQuestionText())
                .generalFeedback(question.getGeneralFeedback())
                .defaultMark(question.getDefaultMark())
                .message(message)
                .build();
    }

    public QueryAllQuestionResponse questionsToQueryAllQuestionResponse(Page<Question> questions) {
        List<QuestionResponseEntity> questionResponseEntities = new ArrayList<>();
        questions.forEach(question -> questionResponseEntities.add(questionToQueryQuestionResponse(question)));
        return QueryAllQuestionResponse.builder()
                .questions(questionResponseEntities)
                .currentPage(questions.getNumber())
                .totalPages(questions.getTotalPages())
                .totalItems(questions.getTotalElements())
                .build();
    }

    public QuestionResponseEntity questionToQueryQuestionResponse(Question question) {
        return QuestionResponseEntity.builder()
                .questionId(question.getId())
                .organizationId(question.getOrganization().getId())
                .difficulty(question.getDifficulty())
                .name(question.getName())
                .questionText(question.getQuestionText())
                .generalFeedback(question.getGeneralFeedback())
                .defaultMark(question.getDefaultMark())
                .build();
    }
}
