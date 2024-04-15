package com.backend.programming.learning.system.course.service.dataaccess.exam_submission.entity;

import com.backend.programming.learning.system.course.service.dataaccess.exam.entity.ExamEntity;
import com.backend.programming.learning.system.course.service.dataaccess.exam_question.entity.ExamQuestionEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.entity.User;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "exam_submission")
public class ExamSubmissionEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "exam_id", referencedColumnName = "id")
    private ExamEntity exam;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    private Integer type;

    private Integer pass_status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamSubmissionEntity that = (ExamSubmissionEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
