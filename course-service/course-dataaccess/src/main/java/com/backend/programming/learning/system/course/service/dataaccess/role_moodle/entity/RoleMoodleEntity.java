package com.backend.programming.learning.system.course.service.dataaccess.role_moodle.entity;

import com.backend.programming.learning.system.course.service.dataaccess.course.entity.CourseEntity;
import com.backend.programming.learning.system.course.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.course.service.dataaccess.question.entity.QuestionEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "role_moodle", schema = "public")
public class RoleMoodleEntity {
    @Id
    @Column(name = "id")
    private Integer id;
    private String name;
}