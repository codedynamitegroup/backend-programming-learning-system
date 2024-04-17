package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface ContestRepository {
    Contest saveContest(Contest contest);

    Optional<Contest> findById(ContestId contestId);

    Page<Contest> findAll(Integer page, Integer size);

    void deleteContestById(UUID contestId);
}
