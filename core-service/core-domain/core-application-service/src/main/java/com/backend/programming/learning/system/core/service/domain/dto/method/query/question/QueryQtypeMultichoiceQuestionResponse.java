package com.backend.programming.learning.system.core.service.domain.dto.method.query.question;

import com.backend.programming.learning.system.core.service.domain.entity.QtypeMultiChoiceQuestion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class QueryQtypeMultichoiceQuestionResponse {
    private final QtypeMultiChoiceQuestion qtypeMultichoiceQuestion;
}
