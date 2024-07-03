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

    @Query(value = """
       select n.* from notification n
       where n.user_id_to = ?1
         and (?2 is null or n.is_read = ?2)
       order by n.created_at desc
""", nativeQuery = true)
    Page<NotificationEntity> findAllByUserIdToAndIsRead(UUID userIdTo,
                                                      Boolean isRead,
                                                      Pageable pageable);

    @Transactional
    @Modifying
    @Query("update NotificationEntity n set n.isRead = ?1, n.updatedAt = ?2 where n.id = ?3")
    int markReadNotificationById(Boolean isRead, ZonedDateTime updatedAt, UUID id);

    @Query("select count(n) from NotificationEntity n where n.userTo.id = ?1 and n.isRead = ?2")
    Integer countAllByUserIdToAndIsRead(UUID userIdTo, Boolean isRead);
}
