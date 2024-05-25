package com.backend.programming.learning.system.core.service.dataaccess.contest.repository;

import com.backend.programming.learning.system.core.service.dataaccess.chapter_question.entity.ChapterQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.contest.entity.ContestEntity;
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
    Optional<ContestEntity> findById(UUID id);

    @Query("select c from ContestEntity c where c.startTime >= ?1")
    Page<ContestEntity> findAllUpcomingContests(ZonedDateTime now, Pageable pageable);

    @Query(value = """
    select c.* from contest c
    where c.start_time >= ?1
    and (cast(?3 as text) IS NULL or
                c.fts_document @@ (to_tsquery( concat(cast(?3 as text),':*') ) && plainto_tsquery( coalesce( cast(?2 as text) ,'') ) ) or
                c.fts_document @@ (to_tsquery( concat(unaccent(cast(?3 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?2 as text) ,'')) ) )
            )
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
    Page<ContestEntity> findAllUpcomingContestsContainsSearchName(
            ZonedDateTime now,  String searchExcludeFinalWord, String searchFinalWord, Pageable pageable);

    @Query("""
            select c from ContestEntity c
            where c.startTime <= ?1 and (c.endTime is null or (c.endTime is not null and c.endTime >= ?1))
            order by c.startTime desc
            """)
    Page<ContestEntity> findAllHappeningContests(ZonedDateTime now, Pageable pageable);

    @Query(value = """
            select c.* from contest c
            where c.start_time <= ?1 and (c.end_time is null or (c.end_time is not null and c.end_time >= ?1))
            and (cast(?3 as text) IS NULL or
                c.fts_document @@ (to_tsquery( concat(cast(?3 as text),':*') ) && plainto_tsquery( coalesce( cast(?2 as text) ,'') ) ) or
                c.fts_document @@ (to_tsquery( concat(unaccent(cast(?3 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?2 as text) ,'')) ) )
            )
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
    Page<ContestEntity> findAllHappeningContestsContainsSearchName(
            ZonedDateTime now, String searchExcludeFinalWord, String searchFinalWord, Pageable pageable);

    @Query("select c from ContestEntity c where c.endTime is not null and c.endTime < ?1")
    Page<ContestEntity> findAllEndedContests(ZonedDateTime now, Pageable pageable);

    @Query(value = """
            select c.* from contest c
            where c.end_time is not null and c.end_time < ?1
            and (cast(?3 as text) IS NULL or
                c.fts_document @@ (to_tsquery( concat(cast(?3 as text),':*') ) && plainto_tsquery( coalesce( cast(?2 as text) ,'') ) ) or
                c.fts_document @@ (to_tsquery( concat(unaccent(cast(?3 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?2 as text) ,'')) ) )
            )
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
    Page<ContestEntity> findAllEndedContestsContainsSearchName(
            ZonedDateTime now, String searchExcludeFinalWord, String searchFinalWord, Pageable pageable);

    @Query(value = """
    select c.* from contest c
    where (cast(?2 as text) IS NULL or
            c.fts_document @@ (to_tsquery( concat(cast(?2 as text),':*') ) && plainto_tsquery( coalesce( cast(?1 as text) ,'') ) ) or
            c.fts_document @@ (to_tsquery( concat(unaccent(cast(?2 as text)),':*') ) && plainto_tsquery( unaccent(coalesce( cast(?1 as text) ,'')) ) )
            )
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
    Page<ContestEntity> findAllContainsSearchName(
            String searchExcludeFinalWord,
            String searchFinalWord,
            Pageable pageable);

    @Query("""
    select c
    from ContestEntity c
    left join ContestUserEntity cu on c.id = cu.contest.id
    where c.startTime > ?1
    group by c.id
    order by count(cu.user.id) desc, c.createdAt desc
    limit 10
""")
    List<ContestEntity> findMostPopularContests(ZonedDateTime now);

    @Query("select count(c.id) from ContestEntity c")
    int countAllContests();
}
