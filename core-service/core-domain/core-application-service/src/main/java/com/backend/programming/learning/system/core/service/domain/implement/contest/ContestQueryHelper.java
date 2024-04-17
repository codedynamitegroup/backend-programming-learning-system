package com.backend.programming.learning.system.core.service.domain.implement.contest;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.ContestNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ContestQueryHelper {
    private final ContestRepository contestRepository;
    private final UserRepository userRepository;

    public ContestQueryHelper(ContestRepository contestRepository,
                              UserRepository userRepository) {
        this.contestRepository = contestRepository;
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public Contest queryContestById(UUID contestId) {
        Optional<Contest> contestResult =
                contestRepository.findById(new ContestId(contestId));
        if (contestResult.isEmpty()) {
            log.warn("Could not find contest with id: {}",
                    contestId);
            throw new ContestNotFoundException("Could not find contest with id: " +
                    contestId);
        }
        User createdBy = getUser(contestResult.get().getCreatedBy().getId().getValue());
        User updatedBy = getUser(contestResult.get().getUpdatedBy().getId().getValue());

        Contest contest = contestResult.get();
        contest.setCreatedBy(createdBy);
        contest.setUpdatedBy(updatedBy);

        log.info("Contest queried with id: {}", contest.getId().getValue());
        return contest;
    }

    private User getUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
        return user.get();
    }

    @Transactional(readOnly = true)
    public Page<Contest> queryAllContests(
            Integer pageNo, Integer pageSize
    ) {
        return contestRepository.findAll(pageNo, pageSize);
    }
}





















