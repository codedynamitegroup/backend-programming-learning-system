package com.backend.programming.learning.system.core.service.domain.dto.method.query.question;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.QuestionResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllQuestionsResponse {
    private final List<QuestionResponseEntity> questionResponses;
}
