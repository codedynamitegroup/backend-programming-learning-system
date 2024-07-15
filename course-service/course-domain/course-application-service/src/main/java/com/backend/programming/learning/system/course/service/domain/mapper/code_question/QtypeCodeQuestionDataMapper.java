package com.backend.programming.learning.system.course.service.domain.mapper.code_question;

import com.backend.programming.learning.system.course.service.domain.dto.messaging.CodeQuestionsUpdateRequest;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.entity.Question;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionBankCategory;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.domain.valueobject.*;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class QtypeCodeQuestionDataMapper {

    public Question codeQuestionsUpdateRequestToQuestion(CodeQuestionsUpdateRequest request, Organization organization, User createdBy, User updatedBy, QuestionBankCategory questionBankCategory) {
        return Question.builder()
                .id(new QuestionId(request.getQuestionId()))
                .name(request.getName())
                .defaultMark(request.getMaxGrade())
                .questionText("")
                .generalFeedback("")
                .organization(organization)
                .difficulty(QuestionDifficulty.valueOf(request.getDifficulty()))
                .updatedBy(updatedBy)
                .createdBy(createdBy)
                .createdAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .updatedAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .questionBankCategory(questionBankCategory)
                .isOrgQuestionBank(request.getIsQuestionBank())
                .qtype(QuestionType.CODE)
                .build();
    }
}
