package com.backend.programming.learning.system.core.service.dataaccess.chapter_question.repository;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.chapter_question.entity.ChapterQuestionEntity;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ChapterQuestionRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ChapterQuestionJpaRepository extends JpaRepository<ChapterQuestionEntity, UUID> {
    Optional<ChapterQuestionEntity> findById(UUID id);
    List<ChapterQuestionEntity> findAllChapterQuestionsByChapterId(UUID chapterId);

    @Query("""
            select cq
            from ChapterQuestionEntity cq
            join ChapterEntity c
            on c.id = cq.chapter.id
            join QuestionEntity q
            on q.id = cq.question.id
            join QtypeCodeQuestionEntity qcq
            on qcq.question.id = q.id
            where c.certificateCourse.id = ?1
            and (q.id not in (
                    select q2.id
                    from QuestionEntity q2
                    join QtypeCodeQuestionEntity qcq2
                    on qcq2.question.id = q2.id
                    join CodeSubmissionEntity cs2
                    on cs2.codeQuestionId = qcq2.id
                    join ChapterQuestionEntity cq2
                    on cq2.question.id = q2.id
                    join ChapterEntity c2
                    on c2.id = cq2.chapter.id
                    where cs2.userId = ?2
                    and c2.certificateCourse.id = ?1
                    and cs2.userId = ?2
                    and cs2.pass = true
                    group by q2.id, cs2.createdAt
                    order by cs2.createdAt desc
            ) or q.id in (
                    select q3.id
                    from QuestionEntity q3
                    join ChapterQuestionEntity cq3
                    on cq3.question.id = q3.id
                    join ChapterEntity c3
                    on c3.id = cq3.chapter.id
                    and c3.certificateCourse.id = ?1
                    join QtypeCodeQuestionEntity qcq3
                    on q3.id = qcq3.question.id
                    where not exists (
                            select 1
                            from CodeSubmissionEntity s3
                            where s3.codeQuestionId = qcq3.id
                    )
            ))
            group by cq.id, q.id, c.no
            order by c.no asc
            limit 1
""")
    Optional<ChapterQuestionEntity> findFirstUncompletedQuestionByCertificateCourseIdAndUserId
            (UUID certificateCourseId, UUID userId);
}

