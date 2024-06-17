package com.backend.programming.learning.system.core.service.domain.implement.service.contest;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest.CreateContestCommand;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.OrganizationNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.contest.ContestDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
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
    private final OrganizationRepository organizationRepository;

    public ContestCreateHelper(CoreDomainService coreDomainService,
                               ContestRepository contestRepository,
                               UserRepository userRepository,
                               ContestDataMapper contestDataMapper,
                               OrganizationRepository organizationRepository) {
        this.coreDomainService = coreDomainService;
        this.contestRepository = contestRepository;
        this.userRepository = userRepository;
        this.contestDataMapper = contestDataMapper;
        this.organizationRepository = organizationRepository;
    }

    @Transactional
    public Contest persistContest(CreateContestCommand createContestCommand) {
        checkOrganization(createContestCommand.getOrgId());
        User user = findUserByEmail(createContestCommand.getEmail());

        Contest contest = contestDataMapper.
                createContestCommandToContest(createContestCommand);
        coreDomainService.createContest(contest);
        contest.setCreatedBy(user);
        contest.setUpdatedBy(user);
        Contest contestResult = saveContest(contest);

        log.info("Contest created with id: {}", contestResult.getId().getValue());
        return contestResult;
    }

    private void checkOrganization(UUID orgId) {
        if (orgId != null) {
            if (organizationRepository.findOrganization(orgId).isEmpty()) {
                log.warn("Organization with id: {} not found", orgId);
                throw new OrganizationNotFoundException("Could not find organization with id: " + orgId);
            }
        }
    }

    private User findUserByEmail(String email) {
        Optional<User> user = userRepository.findUserByEmail(email);
        if (user.isEmpty()) {
            log.warn("User with email: {} not found", email);
            throw new UserNotFoundException("Could not find user with email: " + email);
        }
        return user.get();
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





















