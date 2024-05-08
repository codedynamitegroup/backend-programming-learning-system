package com.backend.programming.learning.system.course.service.dataaccess.course.entity;

import com.backend.programming.learning.system.course.service.dataaccess.course_type.entity.CourseTypeEntity;
import com.backend.programming.learning.system.course.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    @OneToOne
    @JoinColumn(name = "org_id", referencedColumnName = "id")
    private OrganizationEntity organization;


    @ManyToOne
    @JoinColumn(name = "course_type_id", referencedColumnName = "id")
    private CourseTypeEntity courseType;


    private Integer courseIdMoodle;
    private String name;
    private Boolean visible;

    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private UserEntity createdBy;

    @ManyToOne
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
