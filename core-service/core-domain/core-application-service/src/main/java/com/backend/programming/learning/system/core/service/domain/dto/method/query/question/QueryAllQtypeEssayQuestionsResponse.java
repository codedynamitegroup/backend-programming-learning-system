package com.backend.programming.learning.system.core.service.domain.dto.method.query.question;


import com.backend.programming.learning.system.core.service.domain.entity.QtypeEssayQuestion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllQtypeEssayQuestionsResponse {
    private final List<QueryQtypeEssayQuestionResponse> qtypeEssayQuestions;
}
