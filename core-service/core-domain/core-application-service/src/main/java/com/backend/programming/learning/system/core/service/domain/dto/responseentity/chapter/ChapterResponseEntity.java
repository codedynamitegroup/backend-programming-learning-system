package com.backend.programming.learning.system.core.service.domain.dto.responseentity.chapter;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.QuestionResponseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(NON_NULL)
@NoArgsConstructor(force = true)
public class ChapterResponseEntity {
    @NotNull
    @JsonProperty("chapterId")
    private final UUID chapterId;
    @NotNull
    @JsonProperty("certificateCourseId")
    private final UUID certificateCourseId;
    @NotNull
    @JsonProperty("no")
    private final int no;
    @NotNull
    @JsonProperty("title")
    private final String title;
    @NotNull
    @JsonProperty("description")
    private final String description;
    @NotNull
    @JsonProperty("resources")
    private final List<ChapterResourceResponseEntity> resources;
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
}
