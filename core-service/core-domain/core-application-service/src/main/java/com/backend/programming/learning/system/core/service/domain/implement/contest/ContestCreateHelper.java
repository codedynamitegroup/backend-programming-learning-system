package com.backend.programming.learning.system.core.service.domain.implement.contest;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.contest.ContestDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.review.ReviewDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ReviewRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ContestCreateHelper {
    private final CoreDomainService coreDomainService;
    private final ContestRepository contestRepository;
    private final UserRepository userRepository;
    private final ContestDataMapper contestDataMapper;

    public ContestCreateHelper(CoreDomainService coreDomainService,
                               ContestRepository contestRepository,
                               UserRepository userRepository,
                               ContestDataMapper contestDataMapper) {
        this.coreDomainService = coreDomainService;
        this.contestRepository = contestRepository;
        this.userRepository = userRepository;
        this.contestDataMapper = contestDataMapper;
    }

    @Transactional
    public Contest persistContest(CreateContestCommand createContestCommand) {
        checkUser(createContestCommand.getCreatedBy());
        checkUser(createContestCommand.getUpdatedBy());

        Contest contest = contestDataMapper.
                createContestCommandToContest(createContestCommand);
        coreDomainService.createContest(contest);
        Contest contestResult = saveContest(contest);

        log.info("Contest created with id: {}", contestResult.getId().getValue());
        return contestResult;
    }

    private void checkUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
    }

    private Contest saveContest(Contest contest) {
        Contest savedContest = contestRepository
                .saveContest(contest);

        if (savedContest == null) {
            log.error("Could not save contest");

            throw new CoreDomainException("Could not save contest");
        }
        log.info("Contest saved with id: {}", savedContest.getId().getValue());
        return savedContest;
    }
}





















