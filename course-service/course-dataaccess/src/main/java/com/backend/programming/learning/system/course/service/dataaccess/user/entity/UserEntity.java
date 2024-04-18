package com.backend.programming.learning.system.course.service.dataaccess.user.entity;

import com.backend.programming.learning.system.course.service.dataaccess.course.entity.CourseEntity;
import com.backend.programming.learning.system.course.service.dataaccess.exam.entity.ExamEntity;
import com.backend.programming.learning.system.course.service.dataaccess.post.entity.PostEntity;
import com.backend.programming.learning.system.course.service.dataaccess.question.entity.QuestionEntity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    private Date dob;
    private String firstName;
    private String lastName;
    private String avatarUrl;
    private String phone;
    private String address;
    private ZonedDateTime lastLogin;
    private Boolean is_deleted;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.REMOVE)
    private List<CourseEntity> courseCreatedBy;

    @OneToMany(mappedBy = "updatedBy", cascade = CascadeType.REMOVE)
    private List<CourseEntity> courseUpdatedBy;



}