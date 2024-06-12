package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContestRepository {
    Contest saveContest(Contest contest);

    Optional<Contest> findById(ContestId contestId);

    Page<Contest> findAll(String searchName, String startTimeFilter, Integer page, Integer size, Boolean isAdmin);

    Page<Contest> findAllMyContests(String searchName, UUID userId, Integer page, Integer size);

    void deleteContestById(UUID contestId);
    List<Contest> findMostPopularContests();
    int countAllContests();
}
