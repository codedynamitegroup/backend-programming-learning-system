package com.backend.programming.learning.system.core.service.dataaccess.contest_user.repository;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_user.entity.CertificateCourseUserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.contest_user.entity.ContestUserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContestUserJpaRepository extends JpaRepository<ContestUserEntity, UUID> {
    Optional<ContestUserEntity> findById(UUID id);
    Page<ContestUserEntity> findAllByContestId(UUID contestId, Pageable pageable);
    Optional<ContestUserEntity> findByContestIdAndUserId(UUID contestId, UUID userId);
    List<ContestUserEntity> findByContestId(UUID contestId);
    void deleteByContestIdAndUserId(UUID contestId, UUID userId);

    @Query("""
        select count(distinct cu.user.id) from ContestUserEntity cu
    """)
    int countAllParticipants();
}
