package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.shared_solution;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateSharedSolutionCommand {
    @NotNull(message = "email must not be null")
    @Setter
    @JsonIgnore
    String email;

    @NotNull(message = "codeQuestionId must not be null")
    UUID codeQuestionId;

    @NotNull(message = "content must not be null")
    @NotBlank(message = "content must not be blank")
    String content;

    @NotNull(message = "title must not be null")
    @NotBlank(message = "tile must not be blank")
    String title;

    List<UUID> tagIds;
}
