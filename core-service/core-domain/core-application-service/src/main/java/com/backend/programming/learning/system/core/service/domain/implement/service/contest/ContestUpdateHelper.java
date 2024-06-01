package com.backend.programming.learning.system.core.service.domain.implement.service.contest;

import com.backend.programming.learning.system.core.service.domain.dto.method.update.certificatecourse.UpdateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.contest.UpdateContestCommand;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.exception.*;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.core.service.domain.valueobject.SkillLevel;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import com.backend.programming.learning.system.domain.DomainConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ContestUpdateHelper {
    private final ContestRepository contestRepository;
    private final UserRepository userRepository;
    private final ContestUserRepository contestUserRepository;

    public ContestUpdateHelper(ContestRepository contestRepository,
                               UserRepository userRepository,
                               ContestUserRepository contestUserRepository) {
        this.contestRepository = contestRepository;
        this.userRepository = userRepository;
        this.contestUserRepository = contestUserRepository;
    }

    @Transactional
    public void persistContest(UpdateContestCommand updateContestCommand) {
//        checkContestUserExistsByContestId(updateContestCommand.getContestId());
        Contest contest = getContest(updateContestCommand.getContestId());

        User updatedBy = findUserByEmail(updateContestCommand.getEmail());
        contest.setUpdatedBy(updatedBy);
        contest.setUpdatedAt(ZonedDateTime.now(ZoneId.of("UTC")));

        if (updateContestCommand.getName() != null) {
            contest.setName(updateContestCommand.getName());
        }

        if (updateContestCommand.getDescription() != null) {
            contest.setDescription(updateContestCommand.getDescription());
        }

        if (updateContestCommand.getThumbnailUrl() != null) {
            contest.setThumbnailUrl(updateContestCommand.getThumbnailUrl());
        }

        if (updateContestCommand.getPrizes() != null) {
            contest.setPrizes(updateContestCommand.getPrizes());
        }

        if (updateContestCommand.getRules() != null) {
            contest.setRules(updateContestCommand.getRules());
        }

        if (updateContestCommand.getScoring() != null) {
            contest.setScoring(updateContestCommand.getScoring());
        }

        if (updateContestCommand.getStartTime() != null) {
            contest.setStartTime(updateContestCommand.getStartTime());
        }

        if (updateContestCommand.getEndTime() != null) {
            contest.setEndTime(updateContestCommand.getEndTime());
        }

        updateContest(contest);

        log.info("Contest updated with id: {}", contest.getId().getValue());
    }

    private Contest getContest(UUID contestId) {
        Optional<Contest> contest = contestRepository.findById(new ContestId(contestId));
        if (contest.isEmpty()) {
            log.warn("Contest with id: {} not found", contestId);
            throw new ContestNotFoundException("Could not find contest with id: " + contestId);
        }
        return contest.get();
    }

    private User getUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
        return user.get();
    }

    private User findUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            log.warn("User with email: {} not found", email);
            throw new UserNotFoundException("Could not find user with email: " + email);
        }
        return user.get();
    }

    private void updateContest(Contest contest) {
        Contest updatedContest = contestRepository
                .saveContest(contest);

        if (updatedContest == null) {
            log.error("Could not update contest with id: {}", contest.getId().getValue());

            throw new CoreDomainException("Could not update contest with id: " + contest.getId().getValue());
        }
        log.info("Contest updated with id: {}", contest.getId().getValue());
    }

//    private void checkContestUserExistsByContestId(UUID contestId) {
//        List<ContestUser> contestUsers = contestUserRepository.findByContestId(contestId);
//        if (!contestUsers.isEmpty()) {
//            log.error("Cannot update contest with id: {} when there are users registered", contestId);
//            throw new CoreDomainException("Cannot update contest with id: " +
//                    contestId + " when there are users registered");
//        }
//    }
}





















