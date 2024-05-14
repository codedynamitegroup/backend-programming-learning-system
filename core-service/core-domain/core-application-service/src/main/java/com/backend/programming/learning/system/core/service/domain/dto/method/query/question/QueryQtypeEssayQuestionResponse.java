package com.backend.programming.learning.system.core.service.domain.dto.method.query.question;


import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.QtypeEssayQuestionResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class QueryQtypeEssayQuestionResponse {
    private final QtypeEssayQuestionResponseEntity qtypeEssayQuestion;
}
