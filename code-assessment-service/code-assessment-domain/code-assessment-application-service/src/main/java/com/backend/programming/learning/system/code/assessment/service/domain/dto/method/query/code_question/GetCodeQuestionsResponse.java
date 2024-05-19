package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.CodeQuestionDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionResponseItem;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetCodeQuestionsResponse {
    private final List<CodeQuestionDto> codeQuestions;
    private final Integer currentPage;
    private final Long totalItems;
    private final Integer totalPages;
}
