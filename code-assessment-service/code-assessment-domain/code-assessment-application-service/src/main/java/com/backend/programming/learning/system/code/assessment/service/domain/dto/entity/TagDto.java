package com.backend.programming.learning.system.code.assessment.service.domain.dto.entity;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagType;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TagDto {
    UUID id;

    @NotNull(message = "name must not be null")
    String name;

    @NotNull(message = "tagType must not be null")
    TagType tagType;

    Integer numOfCodeQuestion;
}
