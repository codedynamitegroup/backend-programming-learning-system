package com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.tag;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SharedSolutionTagEntityId implements Serializable {
    UUID sharedSolution;
    UUID tag;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SharedSolutionTagEntityId that = (SharedSolutionTagEntityId) o;
        return Objects.equals(sharedSolution, that.sharedSolution) && Objects.equals(tag, that.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sharedSolution, tag);
    }
}
