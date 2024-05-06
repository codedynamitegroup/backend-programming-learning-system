package com.backend.programming.learning.system.code.assessment.service.dataaccess.tag.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.tag.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TagJpaRepository extends JpaRepository<TagEntity, UUID> {
}
