package com.backend.programming.learning.system.course.service.dataaccess.course_user.entity;

import com.backend.programming.learning.system.course.service.dataaccess.course.entity.CourseEntity;
import com.backend.programming.learning.system.course.service.dataaccess.role_moodle.entity.RoleMoodleEntity;
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
@Table(name = "course_user", schema = "public")
@Entity
public class CourseUserEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private CourseEntity course;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private RoleMoodleEntity roleMoodle;

    private ZonedDateTime createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseUserEntity that = (CourseUserEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
