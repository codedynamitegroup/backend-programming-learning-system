package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.comment.vote;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.Vote;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
public class VoteCommentCommand {
    @NotNull(message = "userId must not be null")
    UUID userId;

    @NotNull(message = "voteType must not be null")
    Vote voteType;

//    @Setter
//    @NotNull(message = "sharedSolutionId must not be null")
//    @JsonIgnore
//    UUID sharedSolutionId;

    @Setter
    @NotNull(message = "commentId must not be null")
    @JsonIgnore
    UUID commentId;
}
