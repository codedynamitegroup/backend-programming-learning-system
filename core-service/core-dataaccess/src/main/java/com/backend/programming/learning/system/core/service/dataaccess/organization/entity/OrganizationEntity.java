package com.backend.programming.learning.system.core.service.dataaccess.organization.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "organization")
public class OrganizationEntity {
    @Id
    @Column(name = "id")
    private UUID id;
    private String description;
    private String name;
    private String moodleUrl;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

//    @OneToOne(mappedBy = "organization")
//    private QuestionEntity question;
}
