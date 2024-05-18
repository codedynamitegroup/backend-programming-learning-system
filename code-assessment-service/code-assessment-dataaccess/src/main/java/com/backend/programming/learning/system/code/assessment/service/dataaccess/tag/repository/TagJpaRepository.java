package com.backend.programming.learning.system.code.assessment.service.dataaccess.tag.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.tag.entity.TagEntity;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TagJpaRepository extends JpaRepository<TagEntity, UUID> {

    @Query("""
            select te from TagEntity te
            where (cast(?1 as text) is NULL) or (te.tagType = ?1)
            """)
    List<TagEntity> findAllByTagType(TagType tagType);
}
