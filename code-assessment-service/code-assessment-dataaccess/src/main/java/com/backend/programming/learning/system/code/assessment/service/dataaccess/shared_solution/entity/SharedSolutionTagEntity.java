package com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.tag.entity.TagEntity;
import lombok.*;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="shared_solution_tag")
@IdClass(SharedSolutionTagEntityId.class)
public class SharedSolutionTagEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "shared_solution_id", referencedColumnName = "id")
    SharedSolutionEntity sharedSolution;

    @Id
    @ManyToOne
    @JoinColumn(name = "tag_id", referencedColumnName = "id")
    TagEntity tag;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SharedSolutionTagEntity that = (SharedSolutionTagEntity) o;
        return Objects.equals(sharedSolution, that.sharedSolution) && Objects.equals(tag, that.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sharedSolution, tag);
    }
}
