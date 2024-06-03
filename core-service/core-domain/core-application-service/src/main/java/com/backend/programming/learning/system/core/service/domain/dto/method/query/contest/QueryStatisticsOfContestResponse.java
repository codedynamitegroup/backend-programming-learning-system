package com.backend.programming.learning.system.core.service.domain.dto.method.query.contest;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest_question.ContestQuestionResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryStatisticsOfContestResponse {
    private final Integer numOfSignUps;
    private final Integer numOfParticipantsHavingSubmissions;
    private final List<ContestQuestionResponseEntity> contestQuestions;
}
