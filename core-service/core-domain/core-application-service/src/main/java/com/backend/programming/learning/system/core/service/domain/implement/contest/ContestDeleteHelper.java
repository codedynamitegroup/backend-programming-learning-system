package com.backend.programming.learning.system.core.service.domain.implement.contest;

import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.exception.ChapterNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.ContestNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ChapterRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ContestDeleteHelper {
    private final ContestRepository contestRepository;

    public ContestDeleteHelper(ContestRepository contestRepository) {
        this.contestRepository = contestRepository;
    }

    @Transactional(readOnly = true)
    public void deleteContestById(UUID contestId) {
        checkContestExists(contestId);
        contestRepository.deleteContestById(contestId);
    }

    private void checkContestExists(UUID contestId) {
        Optional<Contest> contest = contestRepository.findById(new ContestId(contestId));
        if (contest.isEmpty()) {
            log.warn("Could not find contest with id: {}", contestId);
            throw new ContestNotFoundException("Could not find contest with id: " + contestId);
        }
    }
}