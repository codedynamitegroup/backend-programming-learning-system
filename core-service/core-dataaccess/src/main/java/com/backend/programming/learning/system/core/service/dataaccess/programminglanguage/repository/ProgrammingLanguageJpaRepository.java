package com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.repository;

import com.backend.programming.learning.system.core.service.dataaccess.chapter.entity.ChapterEntity;
import com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.entity.ProgrammingLanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProgrammingLanguageJpaRepository extends JpaRepository<ProgrammingLanguageEntity, UUID> {
    Optional<ProgrammingLanguageEntity> findById(UUID id);
}
