package com.backend.programming.learning.system.code.assessment.service.domain.dto.entity;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeSubmission;
import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor(force = true)
public class CodeQuestionDto {
    @JsonProperty("id")
    UUID id;
    @JsonProperty("questionId")
    UUID questionId;
    @JsonProperty("name")
    String name;
    @JsonProperty("problemStatement")
    String problemStatement;
    @JsonProperty("inputFormat")
    String inputFormat;
    @JsonProperty("outputFormat")
    String outputFormat;
    @JsonProperty("constraints")
    String constraints;
    @JsonProperty("done")
    Boolean done;
    @JsonProperty("isPublic")
    Boolean isPublic;
    @JsonProperty("allowImport")
    Boolean allowImport;
    @JsonProperty("numOfPeopleAttend")
    Integer numOfPeopleAttend;
    @JsonProperty("difficulty")
    QuestionDifficulty difficulty;
    @JsonProperty("codeSubmissions")
    List<CodeSubmissionDto> codeSubmissions;
    @JsonProperty("sampleTestCases")
    List<TestCaseDto> sampleTestCases;
    @JsonProperty("languages")
    List<ProgrammingLanguageDto> languages;
}
