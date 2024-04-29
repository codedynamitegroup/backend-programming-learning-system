package com.backend.programming.learning.system.course.service.dataaccess.outbox.calendar_event_update_outbox.entity;

import com.backend.programming.learning.system.course.service.domain.valueobject.UpdateState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "calendar_event_update_outbox")
public class CalendarEventUpdateOutboxEntity {
    @Id
    @Column(name = "id")
    private UUID id;
    private UUID sagaId;
    private ZonedDateTime createdAt;
    private ZonedDateTime processedAt;
    private String type;
    private String payload;
    @Enumerated(EnumType.STRING)
    private OutboxStatus outboxStatus;
//    @Enumerated(EnumType.STRING)
//    private SagaStatus sagaStatus;
    @Enumerated(EnumType.STRING)
    private UpdateState updateCalendarEventState;
    @Version
    private int version;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalendarEventUpdateOutboxEntity that = (CalendarEventUpdateOutboxEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
