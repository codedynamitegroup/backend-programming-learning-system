package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.shared_solution;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.validator.OneNotNull.OneNotNull;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
@OneNotNull(
        fields = {"title", "content"},
        message = "title or content must not be null"
)
public class UpdateSharedSolutionCommand {
    @NotNull(message = "userId must not be null")
    UUID userId;

    @NotNull(message = "sharedSolutionId must not be null")
    UUID sharedSolutionId;

    String title;
    String content;

    public void setSharedSolutionId(@NotNull(message = "sharedSolutionId must not be null") UUID sharedSolutionId) {
        this.sharedSolutionId = sharedSolutionId;
    }
}
