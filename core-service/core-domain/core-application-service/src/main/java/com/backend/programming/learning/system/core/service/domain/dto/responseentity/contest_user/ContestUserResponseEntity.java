package com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest_user;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest_question.ContestQuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class ContestUserResponseEntity {
    private final UUID contestId;
    private final UserResponseEntity user;
    private final Integer rank;
    private final Integer totalTime;
    private final Float totalScore;
    private final List<ContestQuestionResponseEntity> contestQuestions;
    private final UUID calendarEventId;
    private final Boolean isCompleted;
    private final ZonedDateTime completedAt;
    private final ZonedDateTime createdAt;
    private final ZonedDateTime updatedAt;
}
