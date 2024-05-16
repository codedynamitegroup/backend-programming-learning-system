package com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.entity.vote;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.entity.CommentEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.SharedSolutionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.vote.SharedSolutionVoteEntityId;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.Vote;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vote_comment")
@IdClass(CommentVoteEntityId.class)
public class CommentVoteEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    UserEntity user;

    @Id
    @ManyToOne
    @JoinColumn(name = "comment_id", referencedColumnName = "id")
    CommentEntity comment;

    @Enumerated(EnumType.STRING)
    Vote voteType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentVoteEntity that = (CommentVoteEntity) o;
        return Objects.equals(user, that.user) && Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, comment);
    }
}
