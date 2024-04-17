package com.backend.programming.learning.system.core.service.dataaccess.contest.repository;

import com.backend.programming.learning.system.core.service.dataaccess.chapter_question.entity.ChapterQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.contest.entity.ContestEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContestJpaRepository extends JpaRepository<ContestEntity, UUID> {
    Optional<ContestEntity> findById(UUID id);

    @Query("select c from ContestEntity c where c.startTime >= ?1")
    Page<ContestEntity> findAllUpcomingContests(ZonedDateTime startTime, Pageable pageable);

    @Query("select c from ContestEntity c where upper(c.name) like upper(concat('%', ?1, '%')) and c.startTime >= ?2")
    Page<ContestEntity> findAllUpcomingContestsContainsSearchName(String name, ZonedDateTime startTime, Pageable pageable);

    @Query("""
            select c from ContestEntity c
            where c.startTime <= ?1 and (c.endTime is null or (c.endTime is not null and c.endTime >= ?2))""")
    Page<ContestEntity> findAllHappeningContests(ZonedDateTime startTime, ZonedDateTime endTime, Pageable pageable);

    @Query("""
            select c from ContestEntity c
            where c.startTime <= ?1 and (c.endTime is null or (c.endTime is not null and c.endTime >= ?2))
            and upper(c.name) like upper(concat('%', ?3, '%'))""")
    Page<ContestEntity> findAllHappeningContestsContainsSearchName(ZonedDateTime startTime, ZonedDateTime endTime, String name, Pageable pageable);

    @Query("select c from ContestEntity c where c.endTime is not null and c.endTime < ?1")
    Page<ContestEntity> findAllEndedContests(ZonedDateTime startTime, Pageable pageable);

    @Query("""
            select c from ContestEntity c
            where c.endTime is not null and c.endTime < ?1
            and upper(c.name) like upper(concat('%', ?2, '%'))""")
    Page<ContestEntity> findAllEndedContestsContainsSearchName(ZonedDateTime startTime, String name, Pageable pageable);

    @Query("select c from ContestEntity c where upper(c.name) like upper(concat('%', ?1, '%'))")
    Page<ContestEntity> findAllContainsSearchName(String name, Pageable pageable);
}
