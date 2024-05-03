package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class GetDetailCodeSubmissionsByIdCommand {
    @NotNull(message =  "userId must not be null")
    UUID userId;

    @NotNull(message = "codeSubmissionId must not be null")
    UUID codeSubmissionId;

}
