package com.backend.programming.learning.system.core.service.dataaccess.contest.repository;

import com.backend.programming.learning.system.core.service.dataaccess.chapter_question.entity.ChapterQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.contest.entity.ContestEntity;
import com.backend.programming.learning.system.core.service.dataaccess.contest.projection.ContestProjection;
import com.backend.programming.learning.system.core.service.dataaccess.topic.entity.TopicEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.domain.valueobject.SkillLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
                c.created_by as createdById,
                c.updated_by as updatedById,
                c.created_at as createdAt,
                c.updated_at as updatedAt,
           (select count(*) from contest_user cu where cu.contest_id = c.id) as numOfParticipants
           from contest c
    where c.start_time >= ?1
    and (cast(?3 as text) IS NULL or
                c.fts_document @@ (to_tsquery( concat(cast(?3 as text),':*') ) && plainto_tsquery( coalesce( cast(?2 as text) ,'') ) ) or
                c.fts_document @@ (to_tsquery( concat(unaccent(cast(?3 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?2 as text) ,'')) ) )
            or cast(?4 as text) IS NULL or UPPER(c.name) like UPPER(concat('%', cast(?4 as text), '%')))
    and (?5 = TRUE or (c.is_public = true))
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
            ZonedDateTime now,
            String searchExcludeFinalWord,
            String searchFinalWord,
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
                c.created_by as createdById,
                c.updated_by as updatedById,
                c.created_at as createdAt,
                c.updated_at as updatedAt,
                (select count(*) from contest_user cu where cu.contest_id = c.id) as numOfParticipants
            from contest c
            where c.start_time <= ?1 and (c.end_time is null or (c.end_time is not null and c.end_time >= ?1))
            and (cast(?3 as text) IS NULL or
                c.fts_document @@ (to_tsquery( concat(cast(?3 as text),':*') ) && plainto_tsquery( coalesce( cast(?2 as text) ,'') ) ) or
                c.fts_document @@ (to_tsquery( concat(unaccent(cast(?3 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?2 as text) ,'')) ) )
                or cast(?4 as text) IS NULL or UPPER(c.name) like UPPER(concat('%', cast(?4 as text), '%')))
            and (?5 = TRUE or (c.is_public = true))
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
            ZonedDateTime now,
            String searchExcludeFinalWord,
            String searchFinalWord,
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
                c.created_by as createdById,
                c.updated_by as updatedById,
                c.created_at as createdAt,
                c.updated_at as updatedAt,
                (select count(*) from contest_user cu where cu.contest_id = c.id) as numOfParticipants
            from contest c
            where c.end_time is not null and c.end_time < ?1
            and (cast(?3 as text) IS NULL or
                c.fts_document @@ (to_tsquery( concat(cast(?3 as text),':*') ) && plainto_tsquery( coalesce( cast(?2 as text) ,'') ) ) or
                c.fts_document @@ (to_tsquery( concat(unaccent(cast(?3 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?2 as text) ,'')) ) )
                or cast(?4 as text) IS NULL or UPPER(c.name) like UPPER(concat('%', cast(?4 as text), '%')))
            and (?5 = TRUE or (c.is_public = true))
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
            ZonedDateTime now,
            String searchExcludeFinalWord,
            String searchFinalWord,
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
                c.created_by as createdById,
                c.updated_by as updatedById,
                c.created_at as createdAt,
                c.updated_at as updatedAt,
                (select count(*) from contest_user cu where cu.contest_id = c.id) as numOfParticipants
    from contest c
    where (cast(?2 as text) IS NULL or
            c.fts_document @@ (to_tsquery( concat(cast(?2 as text),':*') ) && plainto_tsquery( coalesce( cast(?1 as text) ,'') ) ) or
            c.fts_document @@ (to_tsquery( concat(unaccent(cast(?2 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?1 as text) ,'')) ) )
            or cast(?3 as text) IS NULL or UPPER(c.name) like UPPER(concat('%', cast(?3 as text), '%')))
      and (?4 = TRUE or (c.is_public = true))
    order by 
        ts_rank(c.fts_document, 
            case
                when cast(?2 as text) is null then to_tsquery('')
                else (to_tsquery( concat(cast(?2 as text),':*') ) && plainto_tsquery( coalesce( cast(?1 as text) ,'')) )
            end
        ) desc,
        ts_rank(c.fts_document,
            case
                when cast(?2 as text) is null then to_tsquery('')
                else (to_tsquery( concat(unaccent(cast(?2 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?1 as text) ,''))))
            end
        ) desc,
        c.start_time desc
""", nativeQuery = true)
    Page<ContestProjection> findAllContainsSearchName(
            String searchExcludeFinalWord,
            String searchFinalWord,
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
