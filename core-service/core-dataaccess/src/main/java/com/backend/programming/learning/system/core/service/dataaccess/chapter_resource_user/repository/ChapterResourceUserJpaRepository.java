package com.backend.programming.learning.system.core.service.dataaccess.chapter_resource_user.repository;

import com.backend.programming.learning.system.core.service.dataaccess.chapter_resource.entity.ChapterResourceEntity;
import com.backend.programming.learning.system.core.service.dataaccess.chapter_resource_user.entity.ChapterResourceUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ChapterResourceUserJpaRepository extends JpaRepository<ChapterResourceUserEntity, UUID> {
    Optional<ChapterResourceUserEntity> findById(UUID id);

    @Query(value = """
        select exists (
            select 1
            from chapter_resource_user cru, chapter_resource cr
            where cr.id = cru.chapter_resource_id
            and cru.chapter_resource_id = ?1
            and cru.user_id = ?2
            and ((
                    cr.resource_type <> 'CODE'
                    and exists(
                        select 1
                        from chapter_resource_user cru2
                        where cru2.chapter_resource_id = cr.id
                        and cru2.is_viewed = true
                        )
                    )
                or (
                    cr.resource_type = 'CODE'
                    and exists (
                        select 1
                        from qtype_code_question qcq, code_submission cs
                        where cr.question_id = qcq.question_id
                        and qcq.id = cs.code_question_id
                        and cs.user_id = ?2
                        and cs.pass = true
                        )
                    )
                )
            )
""", nativeQuery = true)
    Boolean checkChapterResourceIsCompleted(UUID chapterResourceId, UUID userId);
}

