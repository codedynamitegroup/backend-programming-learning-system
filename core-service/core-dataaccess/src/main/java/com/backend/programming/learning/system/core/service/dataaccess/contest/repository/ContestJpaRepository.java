package com.backend.programming.learning.system.core.service.dataaccess.contest.repository;

import com.backend.programming.learning.system.core.service.dataaccess.contest.entity.ContestEntity;
import com.backend.programming.learning.system.core.service.dataaccess.contest.projection.ContestProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContestJpaRepository extends JpaRepository<ContestEntity, UUID> {
    @Query(value = """
    select c.id as id,
                c.name as name,
                c.description as description,
                c.prizes as prizes,
                c.rules as rules,
                c.scoring as scoring,
                c.thumbnail_url as thumbnailUrl,
                c.start_time as startTime,
                c.end_time as endTime,
                c.is_public as isPublic,
                c.is_restricted_forum as isRestrictedForum,
                c.is_disabled_forum as isDisabledForum,
                c.created_by as createdById,
                c.updated_by as updatedById,
                c.created_at as createdAt,
                c.updated_at as updatedAt,
           (select count(*) from contest_user cu where cu.contest_id = c.id) as numOfParticipants
    from contest c
    where c.id = ?1
""", nativeQuery = true)
    Optional<ContestProjection> findContestById(UUID id);

    @Query(value = """
    select c.id as id,
                c.name as name,
                c.description as description,
                c.prizes as prizes,
                c.rules as rules,
                c.scoring as scoring,
                c.thumbnail_url as thumbnailUrl,
                c.start_time as startTime,
                c.end_time as endTime,
                c.is_public as isPublic,
                c.is_restricted_forum as isRestrictedForum,
                c.is_disabled_forum as isDisabledForum,
                c.created_by as createdById,
                c.updated_by as updatedById,
                c.created_at as createdAt,
                c.updated_at as updatedAt,
           (select count(*) from contest_user cu where cu.contest_id = c.id) as numOfParticipants
           from contest c
    where c.start_time >= ?1
    and cast(?2 as text) IS NULL or UPPER(c.name) like UPPER(concat('%', cast(?2 as text), '%'))
    and (?3 = TRUE or (c.is_public = true))
    order by c.start_time desc
""", nativeQuery = true)
    Page<ContestProjection> findAllUpcomingContestsContainsSearchName(
            ZonedDateTime now,
            String searchValue,
            Boolean isAdmin,
            Pageable pageable);

    @Query(value = """
            select c.id as id,
                c.name as name,
                c.description as description,
                c.prizes as prizes,
                c.rules as rules,
                c.scoring as scoring,
                c.thumbnail_url as thumbnailUrl,
                c.start_time as startTime,
                c.end_time as endTime,
                c.is_public as isPublic,
                c.is_restricted_forum as isRestrictedForum,
                c.is_disabled_forum as isDisabledForum,
                c.created_by as createdById,
                c.updated_by as updatedById,
                c.created_at as createdAt,
                c.updated_at as updatedAt,
                (select count(*) from contest_user cu where cu.contest_id = c.id) as numOfParticipants
            from contest c
            where c.start_time <= ?1 and (c.end_time is null or (c.end_time is not null and c.end_time >= ?1))
            and cast(?2 as text) IS NULL or UPPER(c.name) like UPPER(concat('%', cast(?2 as text), '%'))
            and (?3 = TRUE or (c.is_public = true))
            order by c.start_time desc
            """, nativeQuery = true)
    Page<ContestProjection> findAllHappeningContestsContainsSearchName(
            ZonedDateTime now,
            String searchValue,
            Boolean isAdmin,
            Pageable pageable);

    @Query(value = """
            select c.id as id,
                c.name as name,
                c.description as description,
                c.prizes as prizes,
                c.rules as rules,
                c.scoring as scoring,
                c.thumbnail_url as thumbnailUrl,
                c.start_time as startTime,
                c.end_time as endTime,
                c.is_public as isPublic,
                c.is_restricted_forum as isRestrictedForum,
                c.is_disabled_forum as isDisabledForum,
                c.created_by as createdById,
                c.updated_by as updatedById,
                c.created_at as createdAt,
                c.updated_at as updatedAt,
                (select count(*) from contest_user cu where cu.contest_id = c.id) as numOfParticipants
            from contest c
            where c.end_time is not null and c.end_time < ?1
            and cast(?2 as text) IS NULL or UPPER(c.name) like UPPER(concat('%', cast(?2 as text), '%'))
            and (?3 = TRUE or (c.is_public = true))
            order by c.start_time desc
            """, nativeQuery = true)
    Page<ContestProjection> findAllEndedContestsContainsSearchName(
            ZonedDateTime now,
            String searchValue,
            Boolean isAdmin,
            Pageable pageable);

    @Query(value = """
    select c.id as id,
                c.name as name,
                c.description as description,
                c.prizes as prizes,
                c.rules as rules,
                c.scoring as scoring,
                c.thumbnail_url as thumbnailUrl,
                c.start_time as startTime,
                c.end_time as endTime,
                c.is_public as isPublic,
                c.is_restricted_forum as isRestrictedForum,
                c.is_disabled_forum as isDisabledForum,
                c.created_by as createdById,
                c.updated_by as updatedById,
                c.created_at as createdAt,
                c.updated_at as updatedAt,
                (select count(*) from contest_user cu where cu.contest_id = c.id) as numOfParticipants
    from contest c
    where cast(?1 as text) IS NULL or UPPER(c.name) like UPPER(concat('%', cast(?1 as text), '%'))
      and (?2 = TRUE or (c.is_public = true))
    order by c.start_time desc
""", nativeQuery = true)
    Page<ContestProjection> findAllContainsSearchName(
            String searchValue,
            Boolean isAdmin,
            Pageable pageable);

    @Query(value = """
        select c.id as id,
                c.name as name,
                c.description as description,
                c.prizes as prizes,
                c.rules as rules,
                c.scoring as scoring,
                c.thumbnail_url as thumbnailUrl,
                c.start_time as startTime,
                c.end_time as endTime,
                c.is_public as isPublic,
                c.is_restricted_forum as isRestrictedForum,
                c.is_disabled_forum as isDisabledForum,
                c.created_by as createdById,
                c.updated_by as updatedById,
                c.created_at as createdAt,
                c.updated_at as updatedAt,
                (select count(*) from contest_user cu where cu.contest_id = c.id) as numOfParticipants
        from contest c
        left join contest_user cu on c.id = cu.contest_id
        where c.start_time > ?1 and c.is_public = true
        group by c.id
        order by count(cu.user_id) desc, c.created_at desc
        limit 10
""", nativeQuery = true)
    List<ContestProjection> findMostPopularContests(ZonedDateTime now);

    @Query("select count(c.id) from ContestEntity c")
    int countAllContests();
}
