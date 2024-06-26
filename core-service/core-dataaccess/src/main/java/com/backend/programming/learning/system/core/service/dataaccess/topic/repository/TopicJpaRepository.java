package com.backend.programming.learning.system.core.service.dataaccess.topic.repository;

import com.backend.programming.learning.system.core.service.dataaccess.topic.entity.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TopicJpaRepository extends JpaRepository<TopicEntity, UUID> {
    Optional<TopicEntity> findById(UUID id);

    @Query("""
        select te
        from TopicEntity te
        join CertificateCourseEntity cce on te.id = cce.topic.id
        join CertificateCourseUserEntity ccue on cce.id = ccue.certificateCourse.id
        where ccue.user.id = ?1
    """)
    List<TopicEntity> findAllTopicsOfRegisteredCertificateCoursesByUserId(UUID userId);
}
