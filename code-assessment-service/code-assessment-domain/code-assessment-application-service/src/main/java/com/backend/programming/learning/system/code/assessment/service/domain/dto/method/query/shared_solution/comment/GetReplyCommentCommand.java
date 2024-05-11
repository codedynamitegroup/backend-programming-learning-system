package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@AllArgsConstructor
@Getter
public class GetReplyCommentCommand {
    @NotNull(message = "userId must not be null")
    UUID userId;

//    @NotNull(message = "sharedSolutionId must not be null")
//    @Setter
//    @JsonIgnore
//    UUID sharedSolutionId;

    @NotNull(message = "rootCommentId must not be null")
    @Setter
    @JsonIgnore
    UUID rootCommentId;

}
