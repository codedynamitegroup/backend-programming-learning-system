package com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VoteSharedSolutionEntityId implements Serializable {
    UUID user;
    UUID sharedSolution;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteSharedSolutionEntityId that = (VoteSharedSolutionEntityId) o;
        return Objects.equals(user, that.user) && Objects.equals(sharedSolution, that.sharedSolution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, sharedSolution);
    }
}
