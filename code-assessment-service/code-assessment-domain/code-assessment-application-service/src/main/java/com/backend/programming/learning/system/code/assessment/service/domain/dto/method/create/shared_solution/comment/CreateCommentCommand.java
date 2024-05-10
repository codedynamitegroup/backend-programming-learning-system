package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor
public class CreateCommentCommand {
    @NotNull(message = "userId must not be null")
    UUID userId;

    @Setter
    @NotNull(message = "sharedSolutionId must not be null")
    @JsonIgnore
    UUID sharedSolutionId;

    UUID replyId;

    @NotNull(message = "content must not be null")
    @NotBlank(message = "content must not be blank")
    String content;


}
