package com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.CodeQuestionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.Vote;
import lombok.*;

import jakarta.persistence.*;
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
@Table(name="shared_solution")
@FieldNameConstants
public class SharedSolutionEntity {
    @Id
    UUID id;

    @ManyToOne
    @JoinColumn(name="code_question_id", referencedColumnName = "id")
    private CodeQuestionEntity codeQuestion;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private UserEntity user;

    Integer viewNumber;
    String content;
    String title;

    @Basic(fetch=FetchType.LAZY)
    @Formula("""
            COALESCE((SELECT COUNT(*) FROM vote_shared_solution ssve WHERE ssve.shared_solution_id = id AND ssve.vote_type = 'UPVOTE'), 0)
            - COALESCE((SELECT COUNT(*) FROM vote_shared_solution ssve WHERE ssve.shared_solution_id = id AND ssve.vote_type = 'DOWNVOTE'), 0)
            """)
    Integer totalVoteCount;

    @Basic(fetch=FetchType.LAZY)
    @Formula("""
            coalesce((select count(*) from comment cmt WHERE cmt.shared_solution_id = id), 0)
            """)
    Integer totalComment;

    ZonedDateTime createdAt;
    ZonedDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SharedSolutionEntity that = (SharedSolutionEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
