package com.backend.programming.learning.system.core.service.dataaccess.contest.repository;

import com.backend.programming.learning.system.core.service.dataaccess.contest.entity.ContestEntity;
import com.backend.programming.learning.system.core.service.dataaccess.contest.projection.ContestProjection;
import com.backend.programming.learning.system.core.service.dataaccess.contest.projection.PopularContestDataAccessDTO;
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
           c.org_id as orgId,
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
                count(cu.id) as numOfParticipants
    from contest c
    left join contest_user cu on cu.contest_id = c.id
    where c.id = ?1
    group by c.id
""", nativeQuery = true)
    Optional<ContestProjection> findContestById(UUID id);

    @Query(value = """
    select c.id as id,
           c.org_id as orgId,
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
                count(cu.id) as numOfParticipants
   from contest c
   left join contest_user cu on cu.contest_id = c.id
    where (cast(?3 as text) IS NULL or 
            c.fts_document @@ (to_tsquery( concat(cast(?3 as text),':*') ) && plainto_tsquery( coalesce( cast(?2 as text) ,'') ) ) or
            c.fts_document @@ (to_tsquery( concat(unaccent(cast(?3 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?2 as text) ,'')) ) ) or
            (cast(?1 as text) is not null and UPPER(c.name) like UPPER(concat('%', cast(?1 as text), '%')))
            )
    and c.start_time >= ?4
    and ((?5 = TRUE and c.org_id is null) or (?5 = FALSE and ?7 = FALSE and c.is_public = true) or (?7 = TRUE and ?6 is not null and c.org_id = ?6))
    group by c.id
    order by 
         ts_rank(c.fts_document, 
            case
                when cast(?3 as text) is null then to_tsquery('')
                else (to_tsquery( concat(cast(?3 as text),':*') ) && plainto_tsquery( coalesce( cast(?2 as text) ,'')) )
            end
        ) desc,
        ts_rank(c.fts_document,
            case
                when cast(?3 as text) is null then to_tsquery('')
                else (to_tsquery( concat(unaccent(cast(?3 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?2 as text) ,''))))
            end
        ) desc,
        c.start_time desc
""", nativeQuery = true)
    Page<ContestProjection> findAllUpcomingContestsContainsSearchName(
            String searchValue,
            String searchExcludeFinalWord,
            String searchFinalWord,
            ZonedDateTime now,
            Boolean isAdmin,
            UUID orgId,
            Boolean isOrgAdmin,
            Pageable pageable);

    @Query(value = """
            select c.id as id,
                c.org_id as orgId,
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
                count(cu.id) as numOfParticipants
            from contest c
            left join contest_user cu on cu.contest_id = c.id
            where (cast(?3 as text) IS NULL or 
            c.fts_document @@ (to_tsquery( concat(cast(?3 as text),':*') ) && plainto_tsquery( coalesce( cast(?2 as text) ,'') ) ) or
            c.fts_document @@ (to_tsquery( concat(unaccent(cast(?3 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?2 as text) ,'')) ) ) or
            (cast(?1 as text) is not null and UPPER(c.name) like UPPER(concat('%', cast(?1 as text), '%')))
            )
            and c.start_time <= ?4 and (c.end_time is null or (c.end_time is not null and c.end_time >= ?4))
            and ((?5 = TRUE and c.org_id is null) or (?5 = FALSE and ?7 = FALSE and c.is_public = true) or (?7 = TRUE and ?6 is not null and c.org_id = ?6))
            group by c.id
            order by 
                 ts_rank(c.fts_document, 
                    case
                        when cast(?3 as text) is null then to_tsquery('')
                        else (to_tsquery( concat(cast(?3 as text),':*') ) && plainto_tsquery( coalesce( cast(?2 as text) ,'')) )
                    end
                ) desc,
                ts_rank(c.fts_document,
                    case
                        when cast(?3 as text) is null then to_tsquery('')
                        else (to_tsquery( concat(unaccent(cast(?3 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?2 as text) ,''))))
                    end
                ) desc,
                c.start_time desc
            """, nativeQuery = true)
    Page<ContestProjection> findAllHappeningContestsContainsSearchName(
            String searchValue,
            String searchExcludeFinalWord,
            String searchFinalWord,
            ZonedDateTime now,
            Boolean isAdmin,
            UUID orgId,
            Boolean isOrgAdmin,
            Pageable pageable);

    @Query(value = """
            select c.id as id,
           c.org_id as orgId,
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
                count(cu.id) as numOfParticipants
            from contest c
            left join contest_user cu on cu.contest_id = c.id
            where (cast(?3 as text) IS NULL or 
            c.fts_document @@ (to_tsquery( concat(cast(?3 as text),':*') ) && plainto_tsquery( coalesce( cast(?2 as text) ,'') ) ) or
            c.fts_document @@ (to_tsquery( concat(unaccent(cast(?3 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?2 as text) ,'')) ) ) or
            (cast(?1 as text) is not null and UPPER(c.name) like UPPER(concat('%', cast(?1 as text), '%')))
            )
            and c.end_time is not null and c.end_time < ?4
            and ((?5 = TRUE and c.org_id is null) or (?5 = FALSE and ?7 = FALSE and c.is_public = true) or (?7 = TRUE and ?6 is not null and c.org_id = ?6))
            group by c.id
            order by 
                 ts_rank(c.fts_document, 
                    case
                        when cast(?3 as text) is null then to_tsquery('')
                        else (to_tsquery( concat(cast(?3 as text),':*') ) && plainto_tsquery( coalesce( cast(?2 as text) ,'')) )
                    end
                ) desc,
                ts_rank(c.fts_document,
                    case
                        when cast(?3 as text) is null then to_tsquery('')
                        else (to_tsquery( concat(unaccent(cast(?3 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?2 as text) ,''))))
                    end
                ) desc,
                c.start_time desc
            """, nativeQuery = true)
    Page<ContestProjection> findAllEndedContestsContainsSearchName(
            String searchValue,
            String searchExcludeFinalWord,
            String searchFinalWord,
            ZonedDateTime now,
            Boolean isAdmin,
            UUID orgId,
            Boolean isOrgAdmin,
            Pageable pageable);

    @Query(value = """
    select c.id as id,
           c.org_id as orgId,
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
                count(cu.id) as numOfParticipants
    from contest c
    left join contest_user cu on cu.contest_id = c.id
    where  (cast(?3 as text) IS NULL or 
            c.fts_document @@ (to_tsquery( concat(cast(?3 as text),':*') ) && plainto_tsquery( coalesce( cast(?2 as text) ,'') ) ) or
            c.fts_document @@ (to_tsquery( concat(unaccent(cast(?3 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?2 as text) ,'')) ) ) or
            (cast(?1 as text) is not null and UPPER(c.name) like UPPER(concat('%', cast(?1 as text), '%')))
            )
      and ((?4 = TRUE and c.org_id is null) 
               or (?4 = FALSE and ?6 = FALSE and c.is_public = true) 
               or (?6 = TRUE and ?5 is not null and c.org_id = ?5))
    group by c.id
    order by 
         ts_rank(c.fts_document, 
            case
                when cast(?3 as text) is null then to_tsquery('')
                else (to_tsquery( concat(cast(?3 as text),':*') ) && plainto_tsquery( coalesce( cast(?2 as text) ,'')) )
            end
        ) desc,
        ts_rank(c.fts_document,
            case
                when cast(?3 as text) is null then to_tsquery('')
                else (to_tsquery( concat(unaccent(cast(?3 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?2 as text) ,''))))
            end
        ) desc,
        c.start_time desc
""", nativeQuery = true)
    Page<ContestProjection> findAllContainsSearchName(
            String searchValue,
            String searchExcludeFinalWord,
            String searchFinalWord,
            Boolean isAdmin,
            UUID orgId,
            Boolean isOrgAdmin,
            Pageable pageable);

    @Query(value = """
        select c.id as id,
           c.org_id as orgId,
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
        order by c.start_time asc, count(cu.user_id) desc, c.created_at desc
        limit 10
""", nativeQuery = true)
    List<ContestProjection> findMostPopularContests(ZonedDateTime now);

    @Query(value = """
    select c.id as id,
                c.org_id as orgId,
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
                count(cu.id) as numOfParticipants
    from contest c
    left join contest_user cu on cu.contest_id = c.id
    where (cast(?3 as text) IS NULL or 
            c.fts_document @@ (to_tsquery( concat(cast(?3 as text),':*') ) && plainto_tsquery( coalesce( cast(?2 as text) ,'') ) ) or
            c.fts_document @@ (to_tsquery( concat(unaccent(cast(?3 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?2 as text) ,'')) ) ) or
            (cast(?1 as text) is not null and UPPER(c.name) like UPPER(concat('%', cast(?1 as text), '%')))
            )
    and cu.user_id = ?4
    group by c.id
    order by 
         ts_rank(c.fts_document, 
            case
                when cast(?3 as text) is null then to_tsquery('')
                else (to_tsquery( concat(cast(?3 as text),':*') ) && plainto_tsquery( coalesce( cast(?2 as text) ,'')) )
            end
        ) desc,
        ts_rank(c.fts_document,
            case
                when cast(?3 as text) is null then to_tsquery('')
                else (to_tsquery( concat(unaccent(cast(?3 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?2 as text) ,''))))
            end
        ) desc,
        c.start_time desc
""", nativeQuery = true)
    Page<ContestProjection> findAllMyContestsContainsSearchName(
            String searchValue,
            String searchExcludeFinalWord,
            String searchFinalWord,
            UUID userId,
            Pageable pageable);

    @Query("select count(c.id) from ContestEntity c")
    int countAllContests();

    @Query(value = """
        select c.id as id,
                c.name as contestName,
                c.start_time as startTime,
                c.end_time as endTime,
                c.created_at as createdAt,
                c.updated_at as updatedAt,
                (select count(*) from contest_user cu where cu.contest_id = c.id) as totalParticipants,
                (select count(*) from code_submission_contest cs where cs.contest_id = c.id) as totalSubmissions
        from contest c
        group by c.id
        order by totalParticipants desc, totalSubmissions desc
        limit 5
""", nativeQuery = true)
    List<PopularContestDataAccessDTO> findMostPopularContestsByParticipantAndSubmission();
}
