package com.backend.programming.learning.system.course.service.dataaccess.submission_file.entity;

import com.backend.programming.learning.system.course.service.dataaccess.assignment.entity.AssignmentEntity;
import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_file.entity.AssignmentSubmissionFileEntity;
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
@Table(name = "submission_file")
@Entity
public class SubmissionFileEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "submission_assignment_file_id", referencedColumnName = "id")
    private AssignmentSubmissionFileEntity submissionAssignmentFile;

    private String fileName;
    private Integer fileSize;
    private ZonedDateTime timemodified;
    private String mimetype;
    private String fileUrl;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubmissionFileEntity that = (SubmissionFileEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
