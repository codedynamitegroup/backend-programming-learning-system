package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseUser;
import com.backend.programming.learning.system.core.service.domain.entity.ContestQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContestUserRepository {
    ContestUser saveContestUser(ContestUser contestUser);
    Page<ContestUser> findAllByContestId(
            UUID contestId, Integer pageNo, Integer pageSize, Boolean fetchAll);
    Optional<ContestUser> findByContestIdAndUserId(UUID contestId, UUID userId);
    List<ContestUser> findByContestId(UUID contestId);
    void deleteByContestIdAndUserId(UUID contestId, UUID userId);
    int countAllParticipants();
    Page<ContestUser> findAllContestUsersOfLeaderboard(
            UUID contestId, Integer pageNo, Integer pageSize);
}
