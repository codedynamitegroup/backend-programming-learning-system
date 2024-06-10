package com.backend.programming.learning.system.auth.service.dataaccess.outbox.user_auth_to_any_services.entity;

import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import lombok.*;

import jakarta.persistence.*;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_outbox_auth_to_any_services")
@Entity
public class UserOutboxAuthToAnyServicesEntity {

    @Id
    private UUID id;
    private UUID sagaId;
    private ZonedDateTime createdAt;
    private ZonedDateTime processedAt;
    private String type;
    private String payload;
    @Enumerated(EnumType.STRING)
    private SagaStatus sagaStatus;
    @Enumerated(EnumType.STRING)
    private CopyState copyState;
    @Enumerated(EnumType.STRING)
    private OutboxStatus outboxStatus;
    @Enumerated(EnumType.STRING)
    private ServiceName serviceName;
    @Version
    private int version;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserOutboxAuthToAnyServicesEntity that = (UserOutboxAuthToAnyServicesEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

