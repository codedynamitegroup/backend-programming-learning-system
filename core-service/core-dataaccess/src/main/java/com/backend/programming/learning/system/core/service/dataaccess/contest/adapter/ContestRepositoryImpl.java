package com.backend.programming.learning.system.core.service.dataaccess.contest.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.chapter.mapper.ChapterDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.repository.ChapterJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.contest.mapper.ContestDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.contest.projection.ContestProjection;
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
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
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
        return contestJpaRepository.findContestById(contestId.getValue())
                .map(contestDataAccessMapper::contestProjectionToContest);
    }

    @Override
    public Page<Contest> findAll(String searchName, String startTimeFilter, Integer page, Integer size, Boolean isAdmin) {
        Pageable paging = PageRequest.of(page, size);

        List<String> splitedSearch = contestDataAccessMapper.splitWords(searchName);

        String searchFinalWord = splitedSearch != null && !splitedSearch.isEmpty()? splitedSearch.get(splitedSearch.size() - 1): null;

        if(splitedSearch != null && !splitedSearch.isEmpty())
            splitedSearch.remove(splitedSearch.size() - 1);

        String searchExcludeFinalWord =  splitedSearch != null && !splitedSearch.isEmpty() ? String.join(" ", splitedSearch) : null;

        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
        switch (ContestStartTimeFilter.valueOf(startTimeFilter)) {
            case UPCOMING -> {
                return contestJpaRepository.findAllUpcomingContestsContainsSearchName(
                                now, searchExcludeFinalWord, searchFinalWord, isAdmin, paging)
                        .map(contestDataAccessMapper::contestProjectionToContest);
            }
            case HAPPENING -> {
                return contestJpaRepository.findAllHappeningContestsContainsSearchName(
                                now, searchExcludeFinalWord, searchFinalWord, isAdmin, paging)
                        .map(contestDataAccessMapper::contestProjectionToContest);
            }
            case ENDED -> {
                return contestJpaRepository.findAllEndedContestsContainsSearchName(
                                now, searchExcludeFinalWord, searchFinalWord, isAdmin, paging)
                        .map(contestDataAccessMapper::contestProjectionToContest);
            }
            default -> {
                return contestJpaRepository.findAllContainsSearchName(
                                searchExcludeFinalWord, searchFinalWord, isAdmin, paging)
                        .map(contestDataAccessMapper::contestProjectionToContest);

            }
        }
    }

    @Override
    public void deleteContestById(UUID contestId) {
        contestJpaRepository.deleteById(contestId);
    }

    @Override
    public List<Contest> findMostPopularContests() {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
        return contestJpaRepository.findMostPopularContests(now)
                .stream()
                .map(contestDataAccessMapper::contestProjectionToContest)
                .toList();
    }

    @Override
    public int countAllContests() {
        return contestJpaRepository.countAllContests();
    }
}
