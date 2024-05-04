package com.backend.programming.learning.system.course.service.dataaccess.user.entity;

import com.backend.programming.learning.system.course.service.dataaccess.course.entity.CourseEntity;
import com.backend.programming.learning.system.course.service.dataaccess.question.entity.QuestionEntity;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user", schema = "public")
public class UserEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    private String email;
    private ZonedDateTime dob;
    private String firstName;
    private String lastName;
    private String avatarUrl;
    private String phone;
    private String address;
    private ZonedDateTime lastLogin;
    private Boolean isDeleted;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.REMOVE)
    private List<CourseEntity> courseCreatedBy;

    @OneToMany(mappedBy = "updatedBy", cascade = CascadeType.REMOVE)
    private List<CourseEntity> courseUpdatedBy;

    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.REMOVE)
    private List<QuestionEntity> questionsCreatedBy;
    @OneToMany(mappedBy = "updatedBy", cascade = CascadeType.REMOVE)
    private List<QuestionEntity> questionsUpdatedBy;
}