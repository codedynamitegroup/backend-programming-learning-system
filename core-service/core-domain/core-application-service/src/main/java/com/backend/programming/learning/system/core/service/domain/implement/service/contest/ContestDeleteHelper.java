package com.backend.programming.learning.system.core.service.domain.implement.service.contest;

import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.backend.programming.learning.system.core.service.domain.exception.ChapterNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.ContestNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ChapterRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestUserRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ContestDeleteHelper {
    private final ContestRepository contestRepository;
    private final ContestUserRepository contestUserRepository;

    public ContestDeleteHelper(ContestRepository contestRepository,
                               ContestUserRepository contestUserRepository) {
        this.contestRepository = contestRepository;
        this.contestUserRepository = contestUserRepository;
    }

    @Transactional(readOnly = true)
    public void deleteContestById(UUID contestId) {
        checkContestExists(contestId);
        checkUserRegisteredExists(contestId);
        contestRepository.deleteContestById(contestId);
    }

    private void checkContestExists(UUID contestId) {
        Optional<Contest> contest = contestRepository.findById(new ContestId(contestId));
        if (contest.isEmpty()) {
            log.warn("Could not find contest with id: {}", contestId);
            throw new ContestNotFoundException("Could not find contest with id: " + contestId);
        }
    }

    private void checkUserRegisteredExists(UUID contestId) {
        Page<ContestUser> contestUser = contestUserRepository.findAllByContestId(
                contestId,0,5,false);
        if (contestUser.getTotalElements() > 0) {
            log.warn("Could not delete contest with id: {} as there are users registered", contestId);
            throw new CoreDomainException("Could not delete contest with id: " + contestId +
                    " as there are users registered");
        }
    }
}