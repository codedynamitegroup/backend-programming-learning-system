package com.backend.programming.learning.system.core.service.dataaccess.contest.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.chapter.mapper.ChapterDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.repository.ChapterJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.contest.mapper.ContestDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.contest.repository.ContestJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ChapterRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ContestRepositoryImpl implements ContestRepository {
    private final ContestJpaRepository contestJpaRepository;
    private final ContestDataAccessMapper contestDataAccessMapper;

    public ContestRepositoryImpl(ContestJpaRepository contestJpaRepository,
                                  ContestDataAccessMapper contestDataAccessMapper) {
        this.contestJpaRepository = contestJpaRepository;
        this.contestDataAccessMapper = contestDataAccessMapper;
    }

    @Override
    public Contest saveContest(Contest contest) {
        return contestDataAccessMapper.contestEntityToContest(
                contestJpaRepository
                        .save(contestDataAccessMapper
                                .contestToContestEntity(contest)));
    }

    @Override
    public Optional<Contest> findById(ContestId contestId) {
        return contestJpaRepository.findById(contestId.getValue())
                .map(contestDataAccessMapper::contestEntityToContest);
    }
}
