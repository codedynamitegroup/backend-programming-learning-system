package com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.entity;

import com.backend.programming.learning.system.course.service.dataaccess.assignment.entity.AssignmentEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import lombok.*;

import jakarta.persistence.*;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "submission_assignment")
@Entity
public class SubmissionAssignmentEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "assignment_id", referencedColumnName = "id")
    private AssignmentEntity assignment;

    private Boolean isGraded;

    private Float grade;


    private String content;
    private String feedback;

    private ZonedDateTime submitTime;
    private ZonedDateTime timemodified;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubmissionAssignmentEntity that = (SubmissionAssignmentEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
