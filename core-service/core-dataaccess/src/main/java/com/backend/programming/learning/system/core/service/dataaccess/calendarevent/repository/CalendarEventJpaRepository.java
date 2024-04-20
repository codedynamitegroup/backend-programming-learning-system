package com.backend.programming.learning.system.core.service.dataaccess.calendarevent.repository;

import com.backend.programming.learning.system.core.service.dataaccess.calendarevent.entity.CalendarEventEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CalendarEventJpaRepository extends PagingAndSortingRepository<CalendarEventEntity, UUID> {
}
