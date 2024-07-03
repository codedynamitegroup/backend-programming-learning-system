package com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language.entity.ProgrammingLanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProgrammingLanguageJpaRepository extends JpaRepository<ProgrammingLanguageEntity, UUID> {
    List<ProgrammingLanguageEntity> findAllByOrderByNameAsc();
    List<ProgrammingLanguageEntity> findAllByIsActivedOrderByNameAsc(Boolean active);
}
