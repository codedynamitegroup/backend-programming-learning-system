package com.backend.programming.learning.system.core.service.domain.dto.query.question;


import com.backend.programming.learning.system.core.service.domain.entity.QtypeEssayQuestion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class QueryQtypeEssayQuestionResponse {
    private final QtypeEssayQuestion qtypeEssayQuestion;
}
