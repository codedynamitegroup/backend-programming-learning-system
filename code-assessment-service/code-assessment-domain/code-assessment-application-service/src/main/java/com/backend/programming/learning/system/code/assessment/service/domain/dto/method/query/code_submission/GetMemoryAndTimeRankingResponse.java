package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetMemoryAndTimeRankingResponse {
    Integer totalSubmissionHavingAvgMemoryAndRunTime;
    Integer numberOfSubmissionUnderYouByMemory;
    Integer numberOfSubmissionUnderYouByRunTime;

    Integer totalSubmissionHavingScore;
    Integer numberOfSubmissionUnderYouByScore;
    Integer yourScoreRank;
}
