package com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.vote;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SharedSolutionVoteEntityId implements Serializable {
    UUID user;
    UUID sharedSolution;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SharedSolutionVoteEntityId that = (SharedSolutionVoteEntityId) o;
        return Objects.equals(user, that.user) && Objects.equals(sharedSolution, that.sharedSolution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, sharedSolution);
    }
}
