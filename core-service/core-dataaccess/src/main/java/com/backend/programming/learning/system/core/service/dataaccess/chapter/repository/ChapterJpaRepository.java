package com.backend.programming.learning.system.core.service.dataaccess.chapter.repository;

import com.backend.programming.learning.system.core.service.dataaccess.chapter.entity.ChapterEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ChapterJpaRepository extends JpaRepository<ChapterEntity, UUID> {
    Optional<ChapterEntity> findById(UUID id);
    List<ChapterEntity> findAllByCertificateCourseIdOrderByNoAsc(UUID certificateCourseId);

    @Query(value = "SELECT COALESCE(MAX(no),0) FROM chapter WHERE certificate_course_id = ?1",
            nativeQuery = true)
    Integer findTopNoByCertificateCourseId(UUID certificateCourseId);
}
