package com.backend.programming.learning.system.core.service.dataaccess.contest.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.chapter.mapper.ChapterDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.repository.ChapterJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.contest.mapper.ContestDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.contest.repository.ContestJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ChapterRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestStartTimeFilter;
import com.backend.programming.learning.system.domain.DomainConstants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public Page<Contest> findAll(String searchName, String startTimeFilter, Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size);

        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
        switch (ContestStartTimeFilter.valueOf(startTimeFilter)) {
            case UPCOMING -> {
                if(searchName.isEmpty()){
                    return contestJpaRepository.findAllUpcomingContests(now, paging)
                            .map(contestDataAccessMapper::contestEntityToContest);
                }
                return contestJpaRepository.findAllUpcomingContestsContainsSearchName(searchName, now, paging)
                        .map(contestDataAccessMapper::contestEntityToContest);
            }
            case HAPPENING -> {
                if (searchName.isEmpty()) {
                    return contestJpaRepository.findAllHappeningContests(now, paging)
                            .map(contestDataAccessMapper::contestEntityToContest);
                }
                return contestJpaRepository.findAllHappeningContestsContainsSearchName(now, searchName, paging)
                        .map(contestDataAccessMapper::contestEntityToContest);
            }
            case ENDED -> {
                if (searchName.isEmpty()) {
                    return contestJpaRepository.findAllEndedContests(now, paging)
                            .map(contestDataAccessMapper::contestEntityToContest);
                }
                return contestJpaRepository.findAllEndedContestsContainsSearchName(now, searchName, paging)
                        .map(contestDataAccessMapper::contestEntityToContest);
            }
            default -> {
                if (searchName.isEmpty()) {
                    return contestJpaRepository.findAll(paging)
                            .map(contestDataAccessMapper::contestEntityToContest);
                }
                return contestJpaRepository.findAllContainsSearchName(searchName, paging)
                        .map(contestDataAccessMapper::contestEntityToContest);
            }
        }
    }

    @Override
    public void deleteContestById(UUID contestId) {
        contestJpaRepository.deleteById(contestId);
    }

    @Override
    public Page<Contest> findMostPopularContests() {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
        Pageable paging = PageRequest.of(0, 10);
        return contestJpaRepository.findMostPopularContests(now, paging)
                .map(contestDataAccessMapper::contestEntityToContest);
    }
}
