package com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.chapter.ChapterResourceResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.topic.TopicResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(NON_NULL)
@NoArgsConstructor(force = true)
public class CertificateCourseResponseEntity {
    @NotNull
    @JsonProperty("certificateCourseId")
    private final UUID certificateCourseId;
    @NotNull
    @JsonProperty("name")
    private final String name;
    @NotNull
    @JsonProperty("description")
    private final String description;
    @NotNull
    @JsonProperty("skillLevel")
    private final String skillLevel;
    @NotNull
    @JsonProperty("avgRating")
    private final Float avgRating;
    @NotNull
    @JsonProperty("startTime")
    private final ZonedDateTime startTime;
    @NotNull
    @JsonProperty("endTime")
    private final ZonedDateTime endTime;
    @NotNull
    @JsonProperty("topic")
    private final TopicResponseEntity topic;
    @NotNull
    @JsonProperty("numOfStudents")
    private final Integer numOfStudents;
    @NotNull
    @JsonProperty("numOfResources")
    private final Integer numOfResources;
    @NotNull
    @JsonProperty("numOfCompletedResources")
    private final Integer numOfCompletedResources;
    @NotNull
    @JsonProperty("currentResource")
    private final ChapterResourceResponseEntity currentResource;
    @NotNull
    @JsonProperty("numOfReviews")
    private final Integer numOfReviews;
    @NotNull
    @JsonProperty("isRegistered")
    private final Boolean isRegistered;
    @NotNull
    @JsonProperty("createdBy")
    private final UserResponseEntity createdBy;
    @NotNull
    @JsonProperty("updatedBy")
    private final UserResponseEntity updatedBy;
    @NotNull
    @JsonProperty("createdAt")
    private final ZonedDateTime createdAt;
    @NotNull
    @JsonProperty("updatedAt")
    private final ZonedDateTime updatedAt;
    @NotNull
    @JsonProperty("numOfOneStarReviews")
    private final Integer numOfOneStarReviews;
    @NotNull
    @JsonProperty("numOfTwoStarReviews")
    private final Integer numOfTwoStarReviews;
    @NotNull
    @JsonProperty("numOfThreeStarReviews")
    private final Integer numOfThreeStarReviews;
    @NotNull
    @JsonProperty("numOfFourStarReviews")
    private final Integer numOfFourStarReviews;
    @NotNull
    @JsonProperty("numOfFiveStarReviews")
    private final Integer numOfFiveStarReviews;
}
