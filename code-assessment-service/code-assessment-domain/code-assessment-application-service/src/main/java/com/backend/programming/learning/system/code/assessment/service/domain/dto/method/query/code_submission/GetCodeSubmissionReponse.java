package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.CodeQuestionDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetCodeSubmissionReponse {
    private final List<GetCodeSubmissionResponseItem> codeSubmissions;
    private final Integer currentPage;
    private final Long totalItems;
    private final Integer totalPages;
}
