package com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.Vote;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vote_shared_solution")
@IdClass(VoteSharedSolutionEntityId.class)
public class VoteSharedSolutionEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    UserEntity user;

    @Id
    @ManyToOne
    @JoinColumn(name = "shared_solution_id", referencedColumnName = "id")
    SharedSolutionEntity sharedSolution;

    @Enumerated(EnumType.STRING)
    Vote voteType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteSharedSolutionEntity that = (VoteSharedSolutionEntity) o;
        return Objects.equals(user, that.user) && Objects.equals(sharedSolution, that.sharedSolution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, sharedSolution);
    }
}
