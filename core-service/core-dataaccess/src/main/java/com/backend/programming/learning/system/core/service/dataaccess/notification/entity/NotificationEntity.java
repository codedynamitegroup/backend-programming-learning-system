package com.backend.programming.learning.system.core.service.dataaccess.notification.entity;

import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notification", schema = "public")
@Entity
public class NotificationEntity {
    @Id
    @Column(name = "id")
    private UUID id;
    private UUID userIdFrom;
    private UUID userIdTo;
    private String subject;
    private String fullMessage;
    private String smallMessage;
    private String component;
    private String eventType;
    private String contextUrl;
    private String contextUrlName;
    private Boolean isRead;
    private ZonedDateTime timeRead;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationEntity that = (NotificationEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
