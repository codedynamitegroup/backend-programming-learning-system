package com.backend.programming.learning.system.core.service.dataaccess.user.entity;

import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QuestionEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    private UUID id;

    private String email;
    private String name;
    private Date date;
    private String displayName;
    private String avatarUrl;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    @OneToOne(mappedBy = "createdBy")
    private QuestionEntity questionCreatedBy;

    @OneToOne(mappedBy = "updateBy")
    private QuestionEntity questionUpdateBy;
}
