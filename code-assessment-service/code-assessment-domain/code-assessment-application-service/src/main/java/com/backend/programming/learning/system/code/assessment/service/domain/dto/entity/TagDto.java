package com.backend.programming.learning.system.code.assessment.service.domain.dto.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
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
    String name;
    Integer numOfCodeQuestion;
}
