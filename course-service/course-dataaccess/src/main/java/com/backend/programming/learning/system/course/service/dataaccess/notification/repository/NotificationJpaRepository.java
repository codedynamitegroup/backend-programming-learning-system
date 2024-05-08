package com.backend.programming.learning.system.course.service.dataaccess.notification.repository;

import com.backend.programming.learning.system.course.service.dataaccess.notification.entity.NotificationEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface NotificationJpaRepository extends JpaRepository<NotificationEntity, UUID> {
    Optional<NotificationEntity> findById(UUID id);

    Page<NotificationEntity> findAllByUserTo(UserEntity userTo, Pageable pageable);

    @Transactional
    @Modifying
    @Query("update NotificationEntity n set n.isRead = ?1, n.updatedAt = ?2 where n.id = ?3")
    int markReadNotificationById(Boolean isRead, ZonedDateTime updatedAt, UUID id);
}
