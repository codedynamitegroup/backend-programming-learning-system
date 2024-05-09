package com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.entity;


import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.SharedSolutionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="comment")
public class CommentEntity {
    @Id
    UUID id;

    @ManyToOne
    @JoinColumn(name = "shared_solution_id", referencedColumnName = "id")
    SharedSolutionEntity sharedSolution;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    UserEntity user;

    @OneToOne
    @JoinColumn(name = "reply_id", referencedColumnName = "id")
    CommentEntity comment;

    String content;

    ZonedDateTime createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentEntity that = (CommentEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
