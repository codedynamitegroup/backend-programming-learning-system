package com.backend.programming.learning.system.core.service.domain.dto.method.query.question;

import com.backend.programming.learning.system.core.service.domain.entity.QtypeCodeQuestion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllQtypeCodeQuestionsResponse {
    private final List<QueryQtypeCodeQuestionResponse> qtypeCodeQuestions;
}
