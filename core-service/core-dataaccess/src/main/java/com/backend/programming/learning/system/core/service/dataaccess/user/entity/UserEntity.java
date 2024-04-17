package com.backend.programming.learning.system.core.service.dataaccess.user.entity;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_user.entity.CertificateCourseUserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QuestionEntity;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
    private String firstName;
    private String lastName;
    private Date dob;
    private String avatarUrl;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    @OneToMany(mappedBy = "user")
    private List<CertificateCourseUserEntity> certificateCourseUsers;

    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.REMOVE)
    private List<QuestionEntity> questionsCreatedBy;

    @OneToMany(mappedBy = "updatedBy", cascade = CascadeType.REMOVE)
    private List<QuestionEntity> questionsUpdatedBy;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
