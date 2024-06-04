package com.backend.programming.learning.system.course.service.dataaccess.submission_grade.entity;

import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.entity.SubmissionAssignmentEntity;
import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_file.entity.AssignmentSubmissionFileEntity;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignment;
import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "submission_grade")
@Entity
public class SubmissionGradeEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @OneToOne
    @JoinColumn(name = "submission_assignment_id", referencedColumnName = "id")
    private SubmissionAssignmentEntity submissionAssignment;

   private Float grade;
   private ZonedDateTime timeCreated;
    private ZonedDateTime timeModified;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubmissionGradeEntity that = (SubmissionGradeEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
