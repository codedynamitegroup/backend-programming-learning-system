package com.backend.programming.learning.system.course.service.dataaccess.synchronize_state.entity;

import com.backend.programming.learning.system.course.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStatus;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStep;
import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "synchronize_state")
@Entity
public class SynchronizeStateEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @OneToOne
    @JoinColumn(name = "org_id", referencedColumnName = "id")
    private OrganizationEntity organization;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @Enumerated(EnumType.STRING)
    private SynchronizeStatus status;

    @Enumerated(EnumType.STRING)
    private SynchronizeStep step;

    private Integer syncCount;

    private ZonedDateTime timeCreated;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SynchronizeStateEntity that = (SynchronizeStateEntity) o;
        return Objects.equals(id, that.id);
    }
}
