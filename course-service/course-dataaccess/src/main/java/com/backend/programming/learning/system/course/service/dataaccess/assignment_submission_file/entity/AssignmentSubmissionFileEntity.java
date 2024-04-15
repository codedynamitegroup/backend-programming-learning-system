package com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_file.entity;

import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.entity.AssignmentSubmissionEntity;
import com.backend.programming.learning.system.course.service.dataaccess.course.entity.CourseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assignment_submission_file")
@Entity
public class AssignmentSubmissionFileEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assignment_submission_id", referencedColumnName = "id")
    private AssignmentSubmissionEntity assignmentSubmission;

    private int num_file;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssignmentSubmissionFileEntity that = (AssignmentSubmissionFileEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}