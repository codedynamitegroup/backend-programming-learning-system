package com.backend.programming.learning.system.core.service.dataaccess.notification.repository;

import com.backend.programming.learning.system.core.service.dataaccess.contest_user.entity.ContestUserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.notification.entity.NotificationEntity;
import com.backend.programming.learning.system.core.service.dataaccess.review.entity.ReviewEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface NotificationJpaRepository extends PagingAndSortingRepository<NotificationEntity, UUID> {
    Optional<NotificationEntity> findById(UUID id);

    Page<NotificationEntity> findAllByUserTo(UserEntity userTo, Pageable pageable);

    @Transactional
    @Modifying
    @Query("update NotificationEntity n set n.isRead = ?1 where n.id = ?2")
    int markReadNotificationById(Boolean isRead, UUID id);
}
