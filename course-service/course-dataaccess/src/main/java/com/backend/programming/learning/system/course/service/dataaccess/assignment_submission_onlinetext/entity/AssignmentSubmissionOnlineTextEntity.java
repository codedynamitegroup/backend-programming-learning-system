package com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_onlinetext.entity;

import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.entity.SubmissionAssignmentEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "submission_assignment_onlinetext")
@Entity
public class AssignmentSubmissionOnlineTextEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "submission_assignment_id", referencedColumnName = "id")
    private SubmissionAssignmentEntity assignmentSubmission;

    private String content;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssignmentSubmissionOnlineTextEntity that = (AssignmentSubmissionOnlineTextEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
