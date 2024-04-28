package com.backend.programming.learning.system.core.service.domain.implement.saga.contest_user;

import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.backend.programming.learning.system.core.service.domain.exception.ContestUserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ContestUserSagaHelper {
    private final ContestUserRepository contestUserRepository;

    public ContestUserSagaHelper(ContestUserRepository contestUserRepository) {
        this.contestUserRepository = contestUserRepository;
    }

    ContestUser findContestUserByContestIdAndUserId(UUID contestId, UUID userId) {
        Optional<ContestUser> contestUser = contestUserRepository.findByContestIdAndUserId(contestId, userId);
        if (contestUser.isEmpty()) {
            log.warn("Could not find contest user with contest id: {} and user id: {}", contestId, userId);
            throw new ContestUserNotFoundException("Could not find contest user with contest id: " + contestId +
                    " and user id: " + userId);
        }
        return contestUser.get();
    }

    void saveContestUser(ContestUser contestUser) {
        contestUserRepository.saveContestUser(contestUser);
    }
}
