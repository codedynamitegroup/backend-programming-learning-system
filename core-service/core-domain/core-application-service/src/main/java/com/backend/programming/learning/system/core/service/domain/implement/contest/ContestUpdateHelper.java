package com.backend.programming.learning.system.core.service.domain.implement.contest;

import com.backend.programming.learning.system.core.service.domain.dto.method.update.certificatecourse.UpdateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.contest.UpdateContestCommand;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.*;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.TopicRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
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
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ContestUpdateHelper {
    private final ContestRepository contestRepository;
    private final UserRepository userRepository;

    public ContestUpdateHelper(ContestRepository contestRepository,
                               UserRepository userRepository) {
        this.contestRepository = contestRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void persistContest(UpdateContestCommand updateContestCommand) {
        Contest contest = getContest(updateContestCommand.getContestId());

        User updatedBy = getUser(updateContestCommand.getUpdatedBy());
        contest.setUpdatedBy(updatedBy);
        contest.setUpdatedAt(ZonedDateTime.now(ZoneId.of("UTC")));

        if (updateContestCommand.getName() != null) {
            contest.setName(updateContestCommand.getName());
        }

        if (updateContestCommand.getDescription() != null) {
            contest.setDescription(updateContestCommand.getDescription());
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

    private void updateContest(Contest contest) {
        Contest updatedContest = contestRepository
                .saveContest(contest);

        if (updatedContest == null) {
            log.error("Could not update contest with id: {}", contest.getId().getValue());

            throw new CoreDomainException("Could not update contest with id: " + contest.getId().getValue());
        }
        log.info("Contest updated with id: {}", contest.getId().getValue());
    }
}





















