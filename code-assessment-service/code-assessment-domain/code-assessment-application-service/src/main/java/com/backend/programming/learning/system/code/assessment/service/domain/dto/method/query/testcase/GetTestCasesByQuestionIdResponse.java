package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.testcase;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.TestCaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class GetTestCasesByQuestionIdResponse {
    private final List<TestCaseDto> testCases;
    private final Integer currentPage;
    private final Long totalItems;
    private final Integer totalPages;
}
