package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.CodeQuestionDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionResponseItem;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor(force = true)
public class GetCodeQuestionsResponse {
    @JsonProperty("codeQuestions")
    private final List<CodeQuestionDto> codeQuestions;
    @JsonProperty("currentPage")
    private final Integer currentPage;
    @JsonProperty("totalItems")
    private final Long totalItems;
    @JsonProperty("totalPages")
    private final Integer totalPages;
}
