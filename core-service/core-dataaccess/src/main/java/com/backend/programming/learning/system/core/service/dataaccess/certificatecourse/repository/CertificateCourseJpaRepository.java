package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.repository;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CertificateCourseJpaRepository extends JpaRepository<CertificateCourseEntity, UUID> {
    Optional<CertificateCourseEntity> findById(UUID id);
    Optional<CertificateCourseEntity> findByName(String name);

    @Query(value = """
        select cc.*
        from certificate_course cc
        left join certificate_course_user ccu on cc.id = ccu.certificate_course_id
        where (cast(?2 as text) IS NULL or
                cc.fts_document @@ (to_tsquery( concat(cast(?2 as text),':*') ) && plainto_tsquery( coalesce( cast(?1 as text) ,'') ) ) or
                cc.fts_document @@ (to_tsquery( concat(unaccent(cast(?2 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?1 as text) ,'')) ) )
                or cast(?3 as text) IS NULL or UPPER(cc.name) like UPPER(concat('%', cast(?3 as text), '%')))
         and (cast(?4 as uuid) is null or cc.topic_id = ?4)
         and ccu.user_id = ?5
        order by
            ts_rank(cc.fts_document, 
                case
                    when cast(?2 as text) is null then to_tsquery('')
                    else (to_tsquery( concat(cast(?2 as text),':*') ) && plainto_tsquery( coalesce( cast(?1 as text) ,'')) )
                end
            ) desc,
            ts_rank(cc.fts_document,
                case
                    when cast(?2 as text) is null then to_tsquery('')
                    else (to_tsquery( concat(unaccent(cast(?2 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?1 as text) ,''))))
                end
            ) desc,
            cc.name
""", nativeQuery = true)
    List<CertificateCourseEntity> findAllByCourseNameAndByFilterTopicIdsAndRegisteredBy(
            String searchExcludeFinalWord,
            String searchFinalWord,
            String searchValue,
            UUID topicId,
            UUID registeredBy);

    @Query(value = """
        select cc.*
        from certificate_course cc
        where (cast(?2 as text) IS NULL or
                cc.fts_document @@ (to_tsquery( concat(cast(?2 as text),':*') ) && plainto_tsquery( coalesce( cast(?1 as text) ,'') ) ) or
                cc.fts_document @@ (to_tsquery( concat(unaccent(cast(?2 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?1 as text) ,'')) ) )
                or cast(?3 as text) IS NULL or UPPER(cc.name) like UPPER(concat('%', cast(?3 as text), '%')))
         and (cast(?4 as uuid) is null or cc.topic_id = ?4)
         and cc.id not in (
            select ccu.certificate_course_id
            from certificate_course_user ccu2
            where ccu2.user_id = ?4
         )
        order by
            ts_rank(cc.fts_document, 
                case
                    when cast(?2 as text) is null then to_tsquery('')
                    else (to_tsquery( concat(cast(?2 as text),':*') ) && plainto_tsquery( coalesce( cast(?1 as text) ,'')) )
                end
            ) desc,
            ts_rank(cc.fts_document,
                case
                    when cast(?2 as text) is null then to_tsquery('')
                    else (to_tsquery( concat(unaccent(cast(?2 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?1 as text) ,''))))
                end
            ) desc,
            cc.name
""", nativeQuery = true)
    List<CertificateCourseEntity> findAllByCourseNameAndByFilterTopicIdsAndNotRegisteredBy(
            String searchExcludeFinalWord,
            String searchFinalWord,
            String searchValue,
            UUID topicId,
            UUID registeredBy);

    @Query(value = """
        select cc.*
        from certificate_course cc
        where (cast(?2 as text) IS NULL or
                cc.fts_document @@ (to_tsquery( concat(cast(?2 as text),':*') ) && plainto_tsquery( coalesce( cast(?1 as text) ,'') ) ) or
                cc.fts_document @@ (to_tsquery( concat(unaccent(cast(?2 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?1 as text) ,'')) ) )
                or cast(?3 as text) IS NULL or UPPER(cc.name) like UPPER(concat('%', cast(?3 as text), '%')))
        and (cast(?4 as uuid) is null or cc.topic_id = ?4)
        order by cc.name
""",nativeQuery = true)
    List<CertificateCourseEntity> findAllByCourseNameAndByTopicId(
            String searchExcludeFinalWord,
            String searchFinalWord,
            String searchValue,
            UUID topicId);

    @Query(value = """
        select cc.*
        from certificate_course cc
        left join certificate_course_user ccu on cc.id = ccu.certificate_course_id
        where (cast(?2 as text) IS NULL or
                cc.fts_document @@ (to_tsquery( concat(cast(?2 as text),':*') ) && plainto_tsquery( coalesce( cast(?1 as text) ,'') ) ) or
                cc.fts_document @@ (to_tsquery( concat(unaccent(cast(?2 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?1 as text) ,'')) ) )
                or cast(?3 as text) IS NULL or UPPER(cc.name) like UPPER(concat('%', cast(?3 as text), '%')))
         and (cast(?4 as uuid) is null or cc.topic_id = ?4)
        group by cc.id
        order by 
            ts_rank(cc.fts_document, 
                case
                    when cast(?2 as text) is null then to_tsquery('')
                    else (to_tsquery( concat(cast(?2 as text),':*') ) && plainto_tsquery( coalesce( cast(?1 as text) ,'')) )
                end
            ) desc,
            ts_rank(cc.fts_document,
                case
                    when cast(?2 as text) is null then to_tsquery('')
                    else (to_tsquery( concat(unaccent(cast(?2 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?1 as text) ,''))))
                end
            ) desc,
            count(ccu.user_id) desc
        limit 5
""", nativeQuery = true)
    List<CertificateCourseEntity> findMostEnrolledCertificateCoursesByCourseNameAndByFilterTopicIds(
            String searchExcludeFinalWord,
            String searchFinalWord,
            String searchValue,
            UUID topicId);

    @Query(value = """
        select cc.*
        from certificate_course cc
        left join certificate_course_user ccu on cc.id = ccu.certificate_course_id
        where (cast(?2 as text) IS NULL or
                cc.fts_document @@ (to_tsquery( concat(cast(?2 as text),':*') ) && plainto_tsquery( coalesce( cast(?1 as text) ,'') ) ) or
                cc.fts_document @@ (to_tsquery( concat(unaccent(cast(?2 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?1 as text) ,'')) ) )
                or cast(?3 as text) IS NULL or UPPER(cc.name) like UPPER(concat('%', cast(?3 as text), '%')))
         and (cast(?4 as uuid) is null or cc.topic_id = ?4)
         and ccu.user_id = ?4
        group by cc.id
        order by 
            ts_rank(cc.fts_document, 
                case
                    when cast(?2 as text) is null then to_tsquery('')
                    else (to_tsquery( concat(cast(?2 as text),':*') ) && plainto_tsquery( coalesce( cast(?1 as text) ,'')) )
                end
            ) desc,
            ts_rank(cc.fts_document,
                case
                    when cast(?2 as text) is null then to_tsquery('')
                    else (to_tsquery( concat(unaccent(cast(?2 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?1 as text) ,''))))
                end
            ) desc,
            count(ccu.user_id) desc
        limit 5
""", nativeQuery = true)
    List<CertificateCourseEntity> findMostEnrolledCertificateCoursesByCourseNameAndByFilterTopicIdsAndRegisteredBy(
            String searchExcludeFinalWord,
            String searchFinalWord,
            String searchValue,
            UUID topicId,
            UUID registeredBy);

    @Query(value = """
        select cc.*
        from certificate_course cc
        left join certificate_course_user ccu on cc.id = ccu.certificate_course_id
        where (cast(?2 as text) IS NULL or
                cc.fts_document @@ (to_tsquery( concat(cast(?2 as text),':*') ) && plainto_tsquery( coalesce( cast(?1 as text) ,'') ) ) or
                cc.fts_document @@ (to_tsquery( concat(unaccent(cast(?2 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?1 as text) ,'')) ) )
                or cast(?3 as text) IS NULL or UPPER(cc.name) like UPPER(concat('%', cast(?3 as text), '%')))
         and  (cast(?4 as uuid) is null or cc.topic_id = ?4)
         and cc.id not in (
            select ccu2.certificate_course_id
            from certificate_course_user ccu2
            where ccu2.user_id = ?4
         )
        group by cc.id
        order by 
            ts_rank(cc.fts_document, 
                case
                    when cast(?2 as text) is null then to_tsquery('')
                    else (to_tsquery( concat(cast(?2 as text),':*') ) && plainto_tsquery( coalesce( cast(?1 as text) ,'')) )
                end
            ) desc,
            ts_rank(cc.fts_document,
                case
                    when cast(?2 as text) is null then to_tsquery('')
                    else (to_tsquery( concat(unaccent(cast(?2 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?1 as text) ,''))))
                end
            ) desc,
            count(ccu.user_id) desc
        limit 5
""", nativeQuery = true)
    List<CertificateCourseEntity> findMostEnrolledCertificateCoursesByCourseNameAndByFilterTopicIdsAndNotRegisteredBy(
            String searchExcludeFinalWord,
            String searchFinalWord,
            String searchValue,
            UUID topicId,
            UUID registeredBy);

    void deleteById(UUID id);

    @Query("""
    select count(*)
    from ChapterEntity ce, ChapterQuestionEntity cqe, QuestionEntity qe, QtypeCodeQuestionEntity qcqe, CodeSubmissionEntity cse
    where ce.id = cqe.chapter.id
     and cqe.question.id = qe.id
     and qe.id = qcqe.question.id
     and qcqe.id = cse.codeQuestionId
     and ce.certificateCourse.id = ?1
     and cse.userId = ?2
     and cse.pass = true
""")
    int countNumOfCompletedQuestions(UUID certificateCourseId, UUID userId);

    @Query("""
    select count(*)
    from ChapterEntity ce, ChapterQuestionEntity cqe
    where ce.id = cqe.chapter.id
     and ce.certificateCourse.id = ?1
""")
    int countNumOfQuestionsByCertificateId(UUID certificateCourseId);

    @Query("""
    select count(*) 
    from CertificateCourseUserEntity ccue
    where ccue.certificateCourse.id = ?1
""")
    int countNumOfStudentsByCertificateId(UUID certificateCourseId);

    @Query("""
    select count(*)
    from ReviewEntity re
    where re.certificateCourse.id = ?1
""")
    int countNumOfReviewsByCertificateId(UUID certificateCourseId);
}
