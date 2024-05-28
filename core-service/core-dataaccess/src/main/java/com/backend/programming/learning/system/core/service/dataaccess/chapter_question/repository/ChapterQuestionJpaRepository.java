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
        select cqe
        from ChapterQuestionEntity cqe
        join ChapterEntity ce
        on cqe.chapter.id = ce.id
        join QuestionEntity qe
        on cqe.question.id = qe.id
        join QtypeCodeQuestionEntity qtce
        on qtce.question.id = qe.id
        join CodeSubmissionEntity cse
        on cse.codeQuestionId = qtce.id
        where ce.certificateCourse.id = ?1
        and cse.userId = ?2
        and qe.id not in (
            select qe2.id
            from CodeSubmissionEntity cse2
            join QtypeCodeQuestionEntity qtce2
            on cse2.codeQuestionId = qtce2.id
            join QuestionEntity qe2
            on qe2.id = qtce2.question.id
            join ChapterQuestionEntity cqe2
            on cqe2.question.id = qe2.id
            join ChapterEntity ce2
            on cqe2.chapter.id = ce2.id
            where cse2.userId = ?2
            and ce2.certificateCourse.id = ?1
            and cse2.pass = true
            group by qe2.id
        )
        group by cqe.id, qe.id, ce.no, cse.createdAt
        order by ce.no asc, cse.createdAt desc
        limit 1
""")
    Optional<ChapterQuestionEntity> findFirstUncompletedQuestionByCertificateCourseIdAndUserId
            (UUID certificateCourseId, UUID userId);
}
