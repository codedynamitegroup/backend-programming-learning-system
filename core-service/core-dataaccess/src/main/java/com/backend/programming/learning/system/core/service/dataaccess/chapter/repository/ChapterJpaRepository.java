package com.backend.programming.learning.system.core.service.dataaccess.chapter.repository;

import com.backend.programming.learning.system.core.service.dataaccess.chapter.entity.ChapterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ChapterJpaRepository extends JpaRepository<ChapterEntity, UUID> {
    Optional<ChapterEntity> findById(UUID id);
}
