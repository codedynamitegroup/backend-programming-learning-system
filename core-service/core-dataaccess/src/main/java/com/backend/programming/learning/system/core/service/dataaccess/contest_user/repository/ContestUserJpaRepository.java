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

    // Count sum grade of all code questions with a nearest pass code submission
    @Query(value = """
        select cu.*,
        sum(cs.grade) as sum_grade,
        sum(cs.created_at - c.start_time) as total_time
                from contest_user cu
                join contest c on cu.contest_id = c.id
                join contest_question cq on cu.contest_id = cq.contest_id
                join question q on cq.question_id = q.id
                join qtype_code_question qcq on q.id = qcq.question_id
                left join code_submission cs on qcq.id = cs.code_question_id and cu.user_id = cs.user_id
                where cu.contest_id = ?1
                and ((cs.id = (
                    select cs.id
                    from code_submission cs
                    where cs.code_question_id = qcq.id
                    and cs.user_id = cu.user_id
                    and cs.pass = true
                    order by cs.created_at asc
                    limit 1
                )) or cs.id is null)
                group by cu.id, c.id
                order by sum_grade desc, total_time desc
    """, nativeQuery = true)
    Page<ContestUserEntity> findAllContestUsersOfLeaderboard(UUID contestId, Pageable pageable);
}
