package com.backend.programming.learning.system.code.assessment.service.dataaccess.comment.entity;


import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.SharedSolutionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.Formula;

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
@FieldNameConstants
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
    CommentEntity replyComment;

    Integer replyLevel;
    String content;
    ZonedDateTime createdAt;

    @Basic(fetch = FetchType.LAZY)
    @Formula("""
            COALESCE((SELECT COUNT(*) FROM vote_comment vce WHERE vce.comment_id = id AND vce.vote_type = 'UPVOTE'), 0)
            - COALESCE((SELECT COUNT(*) FROM vote_comment vce WHERE vce.comment_id = id AND vce.vote_type = 'DOWNVOTE'), 0)
            """)
    Integer totalVote;

    @Basic(fetch = FetchType.LAZY)
    @Formula("""
             coalesce((select count(*) from comment ce where ce.reply_id = id), 0)
             """)
    Integer numOfReply;

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
