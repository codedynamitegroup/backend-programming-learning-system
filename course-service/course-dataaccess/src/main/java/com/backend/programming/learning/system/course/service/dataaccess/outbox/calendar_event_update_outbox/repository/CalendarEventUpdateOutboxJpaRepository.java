package com.backend.programming.learning.system.course.service.dataaccess.outbox.calendar_event_update_outbox.repository;

import com.backend.programming.learning.system.course.service.dataaccess.outbox.calendar_event_update_outbox.entity.CalendarEventUpdateOutboxEntity;
import com.backend.programming.learning.system.course.service.domain.valueobject.UpdateState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CalendarEventUpdateOutboxJpaRepository extends JpaRepository<CalendarEventUpdateOutboxEntity, UUID> {

    Optional<CalendarEventUpdateOutboxEntity> findByTypeAndSagaIdAndUpdateCalendarEventState(String type,
                                                                                                   UUID sagaId,
                                                                                                   UpdateState updateCalendarEventState);
    Optional<List<CalendarEventUpdateOutboxEntity>> findByTypeAndOutboxStatus(String type, OutboxStatus outboxStatus);

    void deleteByTypeAndOutboxStatus(String type, OutboxStatus outboxStatus);
}
