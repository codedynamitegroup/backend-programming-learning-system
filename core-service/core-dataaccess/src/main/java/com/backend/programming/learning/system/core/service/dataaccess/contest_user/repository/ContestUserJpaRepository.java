package com.backend.programming.learning.system.core.service.dataaccess.contest_user.repository;

import com.backend.programming.learning.system.core.service.dataaccess.contest_user.projection.ContestUserLeaderboardProjection;
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

    @Query("""
        select cu from ContestUserEntity cu
        where cu.contest.id = ?1 and cu.user.id = ?2
    """)
    Optional<ContestUserEntity> findByContestIdAndUserId(UUID contestId, UUID userId);

    List<ContestUserEntity> findByContestId(UUID contestId);
    void deleteByContestIdAndUserId(UUID contestId, UUID userId);

    @Query("""
        select count(distinct cu.user.id) from ContestUserEntity cu
    """)
    int countAllParticipants();

    @Query(value = """
        select cc.*
        from (select cu.id as id,
                     cu.user_id as userId,
                    cu.contest_id as contestId,
                    cu.calendar_event_id as calendarEventId,
                    cu.update_calendar_event_state as updateCalendarEventState,
                    cu.is_completed as isCompleted,
                    cu.completed_at as completedAt,
                    cu.created_at as createdAt,
                    cu.updated_at as updatedAt,
            sum(cs.grade) as totalScore,
            EXTRACT(EPOCH FROM sum(cs.created_at - c.start_time)) as totalTime,
            DENSE_RANK() OVER (ORDER BY COALESCE(sum(cs.grade), 0) DESC, COALESCE(EXTRACT(EPOCH FROM sum(cs.created_at - c.start_time)), 0) DESC) AS rank
                from contest_user cu
                join contest c on cu.contest_id = c.id
                join contest_question cq on cu.contest_id = cq.contest_id
                join question q on cq.question_id = q.id
                join qtype_code_question qcq on q.id = qcq.question_id
                left join code_submission cs on qcq.id = cs.code_question_id and cu.user_id = cs.user_id
                where cu.contest_id = ?1
                and ((cs.id = (
                    select cs2.id
                    from code_submission cs2
                    join code_submission_contest csc2
                    on cs2.id = csc2.code_submission_id
                    where csc2.contest_id = ?1
                    and cs2.code_question_id = qcq.id
                    and cs2.user_id = cu.user_id
                    and cs2.pass = true
                    and cs2.created_at >= c.start_time and (c.end_time is null or cs2.created_at <= c.end_time)
                    order by cs2.grade desc, cs2.created_at asc
                    limit 1
                )) or cs.id is null)
                group by cu.id, c.id
                ) as cc
    """, nativeQuery = true)
    Page<ContestUserLeaderboardProjection> findAllContestUsersOfLeaderboard(UUID contestId, Pageable pageable);

    @Query(value = """
        select cu.id as id,
            cu.user_id as userId,
            cu.contest_id as contestId,
            cu.calendar_event_id as calendarEventId,
            cu.update_calendar_event_state as updateCalendarEventState,
            cu.is_completed as isCompleted,
            cu.completed_at as completedAt,
            cu.created_at as createdAt,
            cu.updated_at as updatedAt,
            sum(cs.grade) as totalScore,
            EXTRACT(EPOCH FROM sum(cs.created_at - c.start_time)) as totalTime,
            DENSE_RANK() OVER (ORDER BY COALESCE(sum(cs.grade), 0) DESC, COALESCE(EXTRACT(EPOCH FROM sum(cs.created_at - c.start_time)), 0) DESC) AS rank
        from contest_user cu
            join contest c on cu.contest_id = c.id
            join contest_question cq on cu.contest_id = cq.contest_id
            join question q on cq.question_id = q.id
            join qtype_code_question qcq on q.id = qcq.question_id
            left join code_submission cs on qcq.id = cs.code_question_id and cu.user_id = cs.user_id
        where cu.contest_id = ?1
        and cu.user_id = ?2
        and ((cs.id = (
            select cs2.id
            from code_submission cs2
            join code_submission_contest csc2 
            on cs2.id = csc2.code_submission_id
            where csc2.contest_id = ?1
            and cs2.code_question_id = qcq.id
            and cs2.user_id = cu.user_id
            and cs2.pass = true
            and cs2.created_at >= c.start_time and (c.end_time is null or cs2.created_at <= c.end_time)
            order by cs2.grade desc, cs2.created_at asc
            limit 1
        )) or cs.id is null)
        group by cu.id, c.id
    """, nativeQuery = true)
    Optional<ContestUserLeaderboardProjection> findMyRankOfLeaderboard(UUID contestId, UUID userId);

    @Query("""
        select count(distinct cu.user.id) from ContestUserEntity cu where cu.contest.id = ?1
    """)
    int countAllParticipantsByContestId(UUID contestId);

    @Query(value="""
        select count(distinct cu.user_id)
        from contest_user cu
        join contest_question cq on cu.contest_id = cq.contest_id
        join qtype_code_question qcq on cq.question_id = qcq.question_id
        where cu.contest_id = ?1
            and not exists (
                select 1
                from code_submission cs
                where cs.code_question_id = qcq.id
                and cs.user_id = cu.user_id
            )
    """, nativeQuery = true)
    int countAllParticipantsHavingSubmissionsByContestId(UUID contestId);
}
