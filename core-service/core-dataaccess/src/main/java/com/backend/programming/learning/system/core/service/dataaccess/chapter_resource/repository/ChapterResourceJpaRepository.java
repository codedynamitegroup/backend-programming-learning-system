package com.backend.programming.learning.system.core.service.dataaccess.chapter_resource.repository;

import com.backend.programming.learning.system.core.service.dataaccess.chapter_resource.entity.ChapterResourceEntity;
import com.backend.programming.learning.system.core.service.dataaccess.chapter_resource.projection.CourseTypeCountProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ChapterResourceJpaRepository extends JpaRepository<ChapterResourceEntity, UUID> {
    Optional<ChapterResourceEntity> findById(UUID id);
    List<ChapterResourceEntity> findAllChapterQuestionsByChapterId(UUID chapterId);

    @Query("""
        select cq
        from ChapterResourceEntity cq, 
        ChapterEntity c
        where c.id = cq.chapter.id
        and c.certificateCourse.id = ?1
        and ((
                cq.resourceType = 'CODE'
                and (not exists (
                    select 1
                    from CodeSubmissionEntity cs
                    join QtypeCodeQuestionEntity qcq
                    on cs.codeQuestionId = qcq.id
                    where cq.question.id = qcq.question.id
                    and cs.userId = ?2
                    and cs.pass = true
                  )
                  or not exists (
                    select 1
                    from CodeSubmissionEntity cs
                    join QtypeCodeQuestionEntity qcq
                    on cs.codeQuestionId = qcq.id
                    where cq.question.id = qcq.question.id
                    and cs.userId = ?2
                  ))
            )
            or 
            (
                cq.resourceType <> 'CODE'
                and not exists (
                    select 1
                    from ChapterResourceUserEntity cru
                    where cru.chapterResourceId = cq.id
                    and cru.userId = ?2
                    and cru.isViewed = true
                )
            )
        )
        group by cq.id, c.no, cq.no
        order by c.no asc, cq.no asc
        limit 1
""")
    Optional<ChapterResourceEntity> findFirstUncompletedResourceByCertificateCourseIdAndUserId
            (UUID certificateCourseId, UUID userId);

    @Query("""
        select cq
        from ChapterResourceEntity cq, 
        ChapterEntity c
        where c.id = cq.chapter.id
        and c.certificateCourse.id = ?1
        order by c.no desc, cq.no desc
        limit 1
""")
    Optional<ChapterResourceEntity> findLastResourceByCertificateCourseId(UUID certificateCourseId);

    @Query("""
        select cq.resourceType as resourceType, count(cq.resourceType) as count
        from ChapterResourceEntity cq
        group by cq.resourceType
        """)
    List<CourseTypeCountProjection> countResourceByType();

    @Query("""
        select max(cq.no)
        from ChapterResourceEntity cq
        where cq.chapter.id = ?1
        """)
    Integer findTopNoOfChapterResourceByChapterId(UUID chapterId);

}

