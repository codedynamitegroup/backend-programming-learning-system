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
    List<ChapterEntity> findAllByCertificateCourseId(UUID certificateCourseId);

    @Query(value = "SELECT COALESCE(MAX(no),0) FROM chapter WHERE certificate_course_id = :certificateCourseId",
            nativeQuery = true)
    Integer findTopNoByCertificateCourseId(UUID certificateCourseId);

    @Transactional
    @Modifying
    @Query("""
            update ChapterEntity c
            set c.no = ?1,
            c.title = ?2,
            c.description = ?3,
            c.updatedBy = ?4,
            c.updatedAt = ?5
            where c.id = ?6
            """)
    int updateChapterById(
            Integer no, String title, String description, UserEntity userEntity, ZonedDateTime updatedAt, UUID id);
}
