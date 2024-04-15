package com.backend.programming.learning.system.course.service.dataaccess.exam.entity;

import com.backend.programming.learning.system.course.service.dataaccess.course.entity.CourseEntity;
import com.backend.programming.learning.system.course.service.dataaccess.course_user.entity.CourseUserEntity;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "exam_entity")
public class ExamEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private CourseEntity course;

    private String name;
    private String intro;
    private Float score;
    private Float maxScore;
    private ZonedDateTime timeOpen;
    private ZonedDateTime timeClose;
    private ZonedDateTime timeLimit;
    private String overdueHandling;
    private Boolean canRedoQuestions;
    private Integer maxAttempts;
    private Boolean shuffleQuestions;
    private String gradeMethod;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamEntity that = (ExamEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
