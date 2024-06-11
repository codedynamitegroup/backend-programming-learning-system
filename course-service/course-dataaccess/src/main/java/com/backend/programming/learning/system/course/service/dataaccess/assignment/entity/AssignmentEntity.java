package com.backend.programming.learning.system.course.service.dataaccess.assignment.entity;

import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.entity.SubmissionAssignmentEntity;
import com.backend.programming.learning.system.course.service.dataaccess.course.entity.CourseEntity;
import com.backend.programming.learning.system.course.service.domain.valueobject.Type;
import lombok.*;

import jakarta.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assignment")
@Entity
public class AssignmentEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    private Integer assignmentIdMoodle;

    @OneToMany(mappedBy = "assignment")
    private List<SubmissionAssignmentEntity> assignmentSubmissions;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private CourseEntity course;
    private String title;
    private String intro;
    private String activity;
    private Float score;
    private Float maxScore;
    private ZonedDateTime timeOpen;
    private ZonedDateTime timeClose;
    private ZonedDateTime timeLimit;
    private ZonedDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private Type type;
    private Boolean visible;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssignmentEntity that = (AssignmentEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
