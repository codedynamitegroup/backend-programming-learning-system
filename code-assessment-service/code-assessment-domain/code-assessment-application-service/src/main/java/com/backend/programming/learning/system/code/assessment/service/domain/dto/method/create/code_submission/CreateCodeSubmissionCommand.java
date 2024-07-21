package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class CreateCodeSubmissionCommand {
    @NotNull(message = "codeQuestionId must not be null")
    private UUID codeQuestionId;

    private UUID examId;
    private UUID contestId;
    private UUID certificateCourseId;

    @NotNull(message = "email must not be null")
    @JsonIgnore
    @Setter
    private String email;
    @NotNull(message = "languageId must not be null")
    private UUID languageId;

    private UUID codeSubmissionId;

//    @NotNull(message = "headCode must not be null")
//    @Pattern(regexp = "^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$",
//    message = "headCode must be base64 encoded")
//    private String headCode;
//
//    @NotNull(message = "bodyCode must not be null")
//    @Pattern(regexp = "^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$",
//            message = "bodyCode must be base64 encoded")
//    private String bodyCode;
//
//    @NotNull(message = "tailCode must not be null")
//    @Pattern(regexp = "^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$",
//            message = "tailCode must be base64 encoded")
//    private String tailCode;
    @NotNull(message = "sourceCode must not be null")
    @Pattern(regexp = "^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$",
    message = "sourceCode must be base64 encoded")
    private String sourceCode;


    @NotNull(message = "callbackUrl must not be null")
    @URL
    private String callbackUrl;

}
