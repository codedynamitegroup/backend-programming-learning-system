package com.backend.programming.learning.system.code.assessment.service.domain.dto.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor(force = true)
public class CodeSubmissionDto {
    @JsonProperty("id")
    UUID id;
    @JsonProperty("languageId")
    UUID languageId;
    @JsonProperty("sourceCode")
    String sourceCode;
//    String headCode;
//    String bodyCode;
//    String tailCode;
}
