package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class GetMemoryAndTimeRankingResponse {
    Integer totalSubmission;
    Integer numberOfSubmissionUnderYouByMemory;
    Integer numberOfSubmissionUnderYouByRunTime;
}
