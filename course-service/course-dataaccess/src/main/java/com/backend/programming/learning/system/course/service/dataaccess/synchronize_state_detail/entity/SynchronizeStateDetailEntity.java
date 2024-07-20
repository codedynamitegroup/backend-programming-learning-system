package com.backend.programming.learning.system.course.service.dataaccess.synchronize_state_detail.entity;

import com.backend.programming.learning.system.course.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStatus;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStep;
import com.backend.programming.learning.system.domain.valueobject.TypeSynchronize;
import com.backend.programming.learning.system.domain.valueobject.TypeSynchronizeStatus;
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
@Table(name = "synchronize_state_detail")
@Entity
public class SynchronizeStateDetailEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @OneToOne
    @JoinColumn(name = "org_id", referencedColumnName = "id")
    private OrganizationEntity organization;

    @Enumerated(EnumType.STRING)
    private TypeSynchronizeStatus status;

    @Enumerated(EnumType.STRING)
    private TypeSynchronize type;

    private String webhookMessage;

    private ZonedDateTime timeCreated;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SynchronizeStateDetailEntity that = (SynchronizeStateDetailEntity) o;
        return Objects.equals(id, that.id);
    }
}
