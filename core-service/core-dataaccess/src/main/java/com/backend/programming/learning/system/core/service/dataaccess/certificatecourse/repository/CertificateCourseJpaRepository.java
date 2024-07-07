package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.repository;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.projection.MostEnrolledCertificateCourseProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        where cast(?1 as text) IS NULL or UPPER(cc.name) like UPPER(concat('%', cast(?1 as text), '%'))
         and (cast(?2 as uuid) is null or cc.topic_id = ?2)
         and ccu.user_id = ?3
        order by cc.name
""", nativeQuery = true)
    List<CertificateCourseEntity> findAllByCourseNameAndByFilterTopicIdsAndRegisteredBy(
            String searchValue,
            UUID topicId,
            UUID registeredBy);

    @Query(value = """
        select cc.*
        from certificate_course cc
        where cast(?1 as text) IS NULL or UPPER(cc.name) like UPPER(concat('%', cast(?1 as text), '%'))
         and (cast(?2 as uuid) is null or cc.topic_id = ?2)
         and cc.id not in (
            select ccu.certificate_course_id
            from certificate_course_user ccu2
            where ccu2.user_id = ?3
         )
        order by cc.name
""", nativeQuery = true)
    List<CertificateCourseEntity> findAllByCourseNameAndByFilterTopicIdsAndNotRegisteredBy(
            String searchValue,
            UUID topicId,
            UUID registeredBy);

    @Query(value = """
        select cc.*
        from certificate_course cc
        where cast(?1 as text) IS NULL or UPPER(cc.name) like UPPER(concat('%', cast(?1 as text), '%'))
        and (cast(?2 as uuid) is null or cc.topic_id = ?2)
        order by cc.name
""",nativeQuery = true)
    List<CertificateCourseEntity> findAllByCourseNameAndByTopicId(
            String searchValue,
            UUID topicId);

    @Query(value="""
        select cc.*
        from certificate_course cc
        left join certificate_course_user ccu on cc.id = ccu.certificate_course_id
        group by cc.id
        order by cc.avg_rating desc, count(ccu.user_id) desc
        limit 5
""", nativeQuery = true)
    List<CertificateCourseEntity> findMostEnrolledCertificateCourses();

    @Query(value="""
    select cc.id as certificateCourseId, cc.name as certificateCourseName, count(ccu.user_id) as numOfStudents
        from certificate_course cc
        left join certificate_course_user ccu on cc.id = ccu.certificate_course_id
        group by cc.id
        order by cc.avg_rating desc, numOfStudents desc
        limit 5
""", nativeQuery = true)
    List<MostEnrolledCertificateCourseProjection> findMostEnrolledCertificateCoursesWithNumStudentCount();

    @Query("""
        select cc
        from CertificateCourseEntity cc
        left join CertificateCourseUserEntity ccu on cc.id = ccu.certificateCourse.id
        where coalesce(?1, null) is null or cc.topic.id in ?1
        group by cc.id
        order by cc.avgRating desc, count(ccu.user.id) desc
        limit 5
""")
    List<CertificateCourseEntity> findMostEnrolledCertificateCoursesByTopicIds(
            List<UUID> topicIds
    );

    void deleteById(UUID id);

    @Query(value = """
    select count(*)
    from chapter c,
    chapter_resource cr
    where c.id = cr.chapter_id
     and c.certificate_course_id = ?1
     and ((
             cr.resource_type = 'CODE'
            and exists (
            select 1
            from qtype_code_question qcq, 
                code_submission cs
                where qcq.question_id = cr.question_id
                 and qcq.id = cs.code_question_id
                 and cs.user_id = ?2
                 and cs.pass = true
                )
             ) 
             or 
             ( 
                 cr.resource_type <> 'CODE'
                and exists(
                    select 1
                    from chapter_resource_user cru
                    where cr.id = cru.chapter_resource_id
                     and cru.user_id = ?2
                     and cru.is_viewed = true
                    )
                 )
             )
""", nativeQuery = true)
    int countNumOfCompletedResources(UUID certificateCourseId, UUID userId);

    @Query("""
    select count(*)
    from ChapterEntity ce, ChapterResourceEntity cre
    where ce.id = cre.chapter.id
     and ce.certificateCourse.id = ?1
""")
    int countNumOfResourcesByCertificateId(UUID certificateCourseId);

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

    @Query(value = """
        select cc.*
        from certificate_course cc
        where cast(?1 as text) IS NULL or UPPER(cc.name) like UPPER(concat('%', cast(?1 as text), '%'))
        order by cc.name
        """, nativeQuery = true)
    Page<CertificateCourseEntity> findAllCertificateCourse(String searchName, Pageable pageable);


//    Check the certificate course is completed by count the number of resources and the number of completed resources
    // then divide them if > 0.85 then the course is completed else not completed
    @Query(value = """
        select cc.*
        from certificate_course cc, certificate_course_user ccu
        where cc.id = ccu.certificate_course_id
         and ccu.user_id = ?1
        and (select count(*)
                from chapter c, chapter_resource cr
                where c.id = cr.chapter_id
                 and c.certificate_course_id = cc.id) > 0
         and (
            select CAST(count(*)  as numeric(10,1))
            from chapter c, chapter_resource cr
            where c.id = cr.chapter_id
             and c.certificate_course_id = cc.id
             and ((
                     cr.resource_type = 'CODE'
                    and exists (
                    select 1
                    from qtype_code_question qcq, code_submission cs
                        where qcq.question_id = cr.question_id
                             and qcq.id = cs.code_question_id
                             and cs.user_id = ccu.user_id
                             and cs.pass = true
                        )
                     ) 
                     or 
                     ( 
                         cr.resource_type <> 'CODE'
                        and exists(
                            select 1
                            from chapter_resource_user cru
                            where cr.id = cru.chapter_resource_id
                              and cru.user_id = ccu.user_id
                              and cru.is_viewed = true
                            )
                         )
                     )
            ) / (
                select count(*)
                from chapter c, chapter_resource cr
                where c.id = cr.chapter_id
                 and c.certificate_course_id = cc.id
            ) >= 0.85
        order by cc.name
        """, nativeQuery = true)
    Page<CertificateCourseEntity> findAllMyCompletedCertificateCourses(UUID userId, Pageable pageable);
}
