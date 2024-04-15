package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;

import java.util.Optional;

public interface ContestRepository {
    Contest saveContest(Contest contest);

    Optional<Contest> findById(ContestId contestId);
}
