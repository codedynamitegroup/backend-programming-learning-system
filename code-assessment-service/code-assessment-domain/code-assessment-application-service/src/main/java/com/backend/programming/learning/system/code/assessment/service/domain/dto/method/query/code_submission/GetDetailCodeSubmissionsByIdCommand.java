package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class GetDetailCodeSubmissionsByIdCommand {
    @NotNull(message =  "email must not be null")
    String email;

    @NotNull(message = "codeSubmissionId must not be null")
    UUID codeSubmissionId;

}
