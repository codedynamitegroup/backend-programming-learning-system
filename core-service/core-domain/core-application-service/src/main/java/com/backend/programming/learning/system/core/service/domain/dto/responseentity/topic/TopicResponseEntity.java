package com.backend.programming.learning.system.core.service.domain.dto.responseentity.topic;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.programminglanguage.ProgrammingLanguageResponseEntity;
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
public class TopicResponseEntity {
    @NotNull
    private final UUID topicId;
    @NotNull
    private final String name;
    @NotNull
    private final String description;
    @NotNull
    private final String thumbnailUrl;
    @NotNull
    private final Boolean isSingleProgrammingLanguage;
    @NotNull
    private final List<ProgrammingLanguageResponseEntity> programmingLanguages;
    @NotNull
    private final Integer numOfCertificateCourses;
    @NotNull
    private final UserResponseEntity createdBy;
    @NotNull
    private final UserResponseEntity updatedBy;
    @NotNull
    private final ZonedDateTime createdAt;
    @NotNull
    private final ZonedDateTime updatedAt;
}
