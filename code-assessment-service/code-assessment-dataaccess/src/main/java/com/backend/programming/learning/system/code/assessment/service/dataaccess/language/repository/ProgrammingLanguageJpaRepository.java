package com.backend.programming.learning.system.code.assessment.service.dataaccess.language.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.language.entity.ProgrammingLanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProgrammingLanguageJpaRepository extends JpaRepository<ProgrammingLanguageEntity, UUID> {
}
