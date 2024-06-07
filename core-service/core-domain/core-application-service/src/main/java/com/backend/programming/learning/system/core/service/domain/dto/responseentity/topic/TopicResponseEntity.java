package com.backend.programming.learning.system.core.service.domain.dto.responseentity.topic;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.programminglanguage.ProgrammingLanguageResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
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
public class TopicResponseEntity {
    @NotNull
    @JsonProperty("topicId")
    private final UUID topicId;
    @NotNull
    @JsonProperty("name")
    private final String name;
    @NotNull
    @JsonProperty("description")
    private final String description;
    @NotNull
    @JsonProperty("thumbnailUrl")
    private final String thumbnailUrl;
    @NotNull
    @JsonProperty("isSingleProgrammingLanguage")
    private final Boolean isSingleProgrammingLanguage;
    @NotNull
    @JsonProperty("programmingLanguages")
    private final List<ProgrammingLanguageResponseEntity> programmingLanguages;
    @NotNull
    @JsonProperty("numOfCertificateCourses")
    private final Integer numOfCertificateCourses;
    @NotNull
    @JsonProperty("numOfTopics")
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
