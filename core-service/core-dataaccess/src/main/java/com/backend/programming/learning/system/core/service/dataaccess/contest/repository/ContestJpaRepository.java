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

    @Query("""
    select c from ContestEntity c
    where (LENGTH(?1) = 0 OR upper(c.name) like upper(concat('%', ?1, '%')))
    and c.startTime >= ?2
    order by c.startTime desc
""")
    Page<ContestEntity> findAllUpcomingContestsContainsSearchName(String name, ZonedDateTime now, Pageable pageable);

    @Query("""
            select c from ContestEntity c
            where c.startTime <= ?1 and (c.endTime is null or (c.endTime is not null and c.endTime >= ?1))
            order by c.startTime desc
            """)
    Page<ContestEntity> findAllHappeningContests(ZonedDateTime now, Pageable pageable);

    @Query("""
            select c from ContestEntity c
            where c.startTime <= ?1 and (c.endTime is null or (c.endTime is not null and c.endTime >= ?1))
            and (LENGTH(?2) = 0 OR upper(c.name) like upper(concat('%', ?2, '%')))
            order by c.startTime desc
            """)
    Page<ContestEntity> findAllHappeningContestsContainsSearchName(ZonedDateTime now, String name, Pageable pageable);

    @Query("select c from ContestEntity c where c.endTime is not null and c.endTime < ?1")
    Page<ContestEntity> findAllEndedContests(ZonedDateTime now, Pageable pageable);

    @Query("""
            select c from ContestEntity c
            where c.endTime is not null and c.endTime < ?1
            and (LENGTH(?2) = 0 OR upper(c.name) like upper(concat('%', ?2, '%')))
            order by c.startTime desc
            """)
    Page<ContestEntity> findAllEndedContestsContainsSearchName(ZonedDateTime now, String name, Pageable pageable);

    @Query("""
    select c from ContestEntity c
    where (LENGTH(?1) = 0 OR upper(c.name) like upper(concat('%', ?1, '%')))
    order by c.startTime desc
""")
    Page<ContestEntity> findAllContainsSearchName(String name, Pageable pageable);

    @Query("""
    select c
    from ContestEntity c
    left join ContestUserEntity cu on c.id = cu.contest.id
    where (c.startTime > ?1 OR (c.startTime <= ?1 and (c.endTime is null or (c.endTime is not null and c.endTime >= ?1))))
    group by c.id
    order by count(cu.user.id) desc, c.createdAt desc
    limit 10
""")
    List<ContestEntity> findMostPopularContests(ZonedDateTime now);

    @Query("select count(c.id) from ContestEntity c")
    int countAllContests();
}
