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
        select cce
        from CertificateCourseEntity cce, CertificateCourseUserEntity ccue
        where cce.id = ccue.certificateCourse.id
         and (LENGTH(?1) = 0 OR (UPPER(cce.name) like UPPER(CONCAT('%', ?1, '%'))))
         and ((?2 is NULL) OR (cce.topic.id in ?2))
         and ccue.user.id = ?3
        order by cce.name
""")
    List<CertificateCourseEntity> findAllByCourseNameAndByFilterTopicIdsAndRegisteredBy(
            String courseName,
            List<UUID> filterTopicIds,
            UUID registeredBy);

    @Query(value = """
        select cce
        from CertificateCourseEntity cce
        where (LENGTH(?1) = 0 OR (UPPER(cce.name) like UPPER(CONCAT('%', ?1, '%'))))
         and ((?2 is NULL) OR (cce.topic.id in ?2))
         and cce.id not in (
            select ccue.certificateCourse.id
            from CertificateCourseUserEntity ccue
            where ccue.user.id = ?3
         )
        order by cce.name
""")
    List<CertificateCourseEntity> findAllByCourseNameAndByFilterTopicIdsAndNotRegisteredBy(
            String courseName,
            List<UUID> filterTopicIds,
            UUID registeredBy);

    @Query(value = """
        select cce
        from CertificateCourseEntity cce
        where (LENGTH(?1) = 0 OR (UPPER(cce.name) like UPPER(CONCAT('%', ?1, '%'))))
         and ((?2 is NULL) OR (cce.topic.id in ?2))
        order by cce.name
""")
    List<CertificateCourseEntity> findAllByCourseNameAndByFilterTopicIds(
            String courseName,
            List<UUID> filterTopicIds);

    @Query(value = """
        select cce
        from CertificateCourseEntity cce
        left join CertificateCourseUserEntity ccue
        on cce.id = ccue.certificateCourse.id
        where (LENGTH(?1) = 0 OR (UPPER(cce.name) like UPPER(CONCAT('%', ?1, '%'))))
         and ((?2 is NULL) OR (cce.topic.id in ?2))
        group by cce.id
        order by count(ccue.user.id) desc
        limit 5
""")
    List<CertificateCourseEntity> findMostEnrolledCertificateCoursesByCourseNameAndByFilterTopicIds(
            String courseName,
            List<UUID> filterTopicIds);

    @Query(value = """
        select cce
        from CertificateCourseEntity cce
        left join CertificateCourseUserEntity ccue
        on cce.id = ccue.certificateCourse.id
        where (LENGTH(?1) = 0 OR (UPPER(cce.name) like UPPER(CONCAT('%', ?1, '%'))))
         and ((?2 is NULL) OR (cce.topic.id in ?2))
         and ccue.user.id = ?3
        group by cce.id
        order by count(ccue.user.id) desc
        limit 5
""")
    List<CertificateCourseEntity> findMostEnrolledCertificateCoursesByCourseNameAndByFilterTopicIdsAndRegisteredBy(
            String courseName,
            List<UUID> filterTopicIds,
            UUID registeredBy);

    @Query(value = """
        select cce
        from CertificateCourseEntity cce
        left join CertificateCourseUserEntity ccue
        on cce.id = ccue.certificateCourse.id
        where (LENGTH(?1) = 0 OR (UPPER(cce.name) like UPPER(CONCAT('%', ?1, '%'))))
         and ((?2 is NULL) OR (cce.topic.id in ?2))
         and cce.id not in (
            select ccue.certificateCourse.id
            from CertificateCourseUserEntity ccue
            where ccue.user.id = ?3
         )
        group by cce.id
        order by count(ccue.user.id) desc
        limit 5
""")
    List<CertificateCourseEntity> findMostEnrolledCertificateCoursesByCourseNameAndByFilterTopicIdsAndNotRegisteredBy(
            String courseName,
            List<UUID> filterTopicIds,
            UUID registeredBy);

    void deleteById(UUID id);
}
