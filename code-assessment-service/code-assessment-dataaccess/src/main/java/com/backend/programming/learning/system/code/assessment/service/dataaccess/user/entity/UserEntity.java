package com.backend.programming.learning.system.code.assessment.service.dataaccess.user.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user")
public class UserEntity {
    @Id
    private UUID id;
}
