package com.backend.programming.learning.system.core.service.domain.implement.service.contest_user;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest_user.CreateContestUserCommand;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.event.contest_user.ContestUserUpdatedEvent;
import com.backend.programming.learning.system.core.service.domain.exception.ContestNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.contest_user.ContestUserDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestUserRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ContestUserCreateHelper {
    private final CoreDomainService coreDomainService;
    private final ContestRepository contestRepository;
    private final UserRepository userRepository;
    private final ContestUserRepository contestUserRepository;
    private final ContestUserDataMapper contestUserDataMapper;

    public ContestUserCreateHelper(CoreDomainService coreDomainService,
                                   ContestRepository contestRepository,
                                   UserRepository userRepository,
                                   ContestUserRepository contestUserRepository,
                                   ContestUserDataMapper contestUserDataMapper) {
        this.coreDomainService = coreDomainService;
        this.contestRepository = contestRepository;
        this.userRepository = userRepository;
        this.contestUserRepository = contestUserRepository;
        this.contestUserDataMapper = contestUserDataMapper;
    }

    @Transactional
    public ContestUserUpdatedEvent persistContestUser(CreateContestUserCommand createContestUserCommand) {
        User user = getUser(createContestUserCommand.getUserId());
        Contest contest = getContest(createContestUserCommand.getContestId());
        checkContestUserByContestIdAndUserId(
                createContestUserCommand.getContestId(),
                createContestUserCommand.getUserId());
        checkEndTimeIsNotExpired(contest);

        ContestUser contestUser = contestUserDataMapper.
                createContestUserCommandToContestUser(createContestUserCommand);
        contestUser.setUser(user);
        contestUser.setContest(contest);
        ContestUserUpdatedEvent contestUserUpdatedEvent = coreDomainService.createContestUser(contestUser);
        saveContestUser(contestUser);

        log.info("Contest User created with id: {}", contestUserUpdatedEvent.getContestUser().getId().getValue());
        return contestUserUpdatedEvent;
    }

    private void checkEndTimeIsNotExpired(Contest contest) {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
        if (contest.getEndTime() != null && contest.getEndTime().isBefore(now)) {
            log.warn("Contest with id: {} has already ended", contest.getId().getValue());
            throw new CoreDomainException("Contest with id: " + contest.getId().getValue() + " has already ended");
        }
    }

    private User getUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
        return user.get();
    }

    private Contest getContest(UUID contestId) {
        Optional<Contest> contest = contestRepository.findById(new ContestId(contestId));
        if (contest.isEmpty()) {
            log.warn("Contest with id: {} not found", contestId);
            throw new ContestNotFoundException("Could not find contest with id: " + contestId);
        }
        return contest.get();
    }

    private void checkContestUserByContestIdAndUserId(UUID contestId, UUID userId) {
        Optional<ContestUser> contestUser = contestUserRepository.findByContestIdAndUserId(contestId, userId);
        if (contestUser.isPresent()) {
            log.warn("User with id: {} is already registered for the contest with id: {}", userId, contestId);
            throw new CoreDomainException("User with id: " +
                    userId +
                    " is already registered for the contest with id: " +
                    contestId);
        }
    }

    private void saveContestUser(ContestUser contestUser) {
        ContestUser savedContestUser = contestUserRepository
                .saveContestUser(contestUser);

        if (savedContestUser == null) {
            log.error("Could not save contest user");

            throw new CoreDomainException("Could not save contest user");
        }
        log.info("Contest User saved with id: {}", savedContestUser.getId().getValue());
    }
}





















