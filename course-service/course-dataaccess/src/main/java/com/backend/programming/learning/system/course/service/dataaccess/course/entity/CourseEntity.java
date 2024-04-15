package com.backend.programming.learning.system.course.service.dataaccess.course.entity;

import com.backend.programming.learning.system.course.service.dataaccess.assignment.entity.AssignmentEntity;
import com.backend.programming.learning.system.course.service.dataaccess.course_user.entity.CourseUserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.exam.entity.ExamEntity;
import com.backend.programming.learning.system.course.service.dataaccess.post.entity.PostEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
@Entity
public class CourseEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    private String name;
    private Boolean visible;

    @OneToMany(mappedBy = "course")
    List<AssignmentEntity> assignments;

    @OneToMany(mappedBy = "course")
    List<ExamEntity> exams;

    @OneToMany(mappedBy = "course")
    List<PostEntity> posts;

    @OneToMany(mappedBy = "course")
    List<CourseUserEntity> courseUsers;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private UserEntity createdBy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "updated_by", referencedColumnName = "id")
    private UserEntity updatedBy;

    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseEntity that = (CourseEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
