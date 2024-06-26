package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.shared_solution.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
public class UpdateCommentCommand {
    @NotNull(message = "email must not be null")
    @Setter
    @JsonIgnore
    String email;

    @NotNull(message = "commentId must not be null")
    @Setter
    @JsonIgnore
    UUID commentId;

    @NotNull(message = "content must not be null")
    @NotBlank(message = "content must not be blank")
    String content;
}
