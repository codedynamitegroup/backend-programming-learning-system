package com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.topic.TopicResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class CertificateCourseResponseEntity {
    @NotNull
    private final UUID certificateCourseId;
    @NotNull
    private final String name;
    @NotNull
    private final String description;
    @NotNull
    private final String skillLevel;
    @NotNull
    private final Float avgRating;
    @NotNull
    private final ZonedDateTime startTime;
    @NotNull
    private final ZonedDateTime endTime;
    @NotNull
    private final TopicResponseEntity topic;
    @NotNull
    private final Integer numOfStudents;
    @NotNull
    private final Integer numOfQuestions;
    @NotNull
    private final Integer numOfCompletedQuestions;
    @NotNull
    private final Integer numOfReviews;
    @NotNull
    private final QuestionResponseEntity currentQuestion;
    @NotNull
    private final Boolean isRegistered;
    @NotNull
    private final UserResponseEntity createdBy;
    @NotNull
    private final UserResponseEntity updatedBy;
    @NotNull
    private final ZonedDateTime createdAt;
    @NotNull
    private final ZonedDateTime updatedAt;
}
