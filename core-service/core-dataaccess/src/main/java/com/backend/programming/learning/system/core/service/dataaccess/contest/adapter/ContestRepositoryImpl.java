package com.backend.programming.learning.system.core.service.dataaccess.contest.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.contest.mapper.ContestDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.contest.repository.ContestJpaRepository;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.contest.PopularContestDTO;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestStartTimeFilter;
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
    public Page<Contest> findAll(String searchName,
                                 String startTimeFilter,
                                 Integer page,
                                 Integer size,
                                 Boolean isAdmin,
                                 UUID orgId,
                                 Boolean isOrgAdmin) {
        Pageable paging = PageRequest.of(page, size);

        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));

        List<String> splitedSearch = contestDataAccessMapper.splitWords(searchName);

        String searchFinalWord = splitedSearch != null && !splitedSearch.isEmpty()? splitedSearch.get(splitedSearch.size() - 1): null;

        if(splitedSearch != null && !splitedSearch.isEmpty())
            splitedSearch.remove(splitedSearch.size() - 1);

        String searchExcludeFinalWord =  splitedSearch != null && !splitedSearch.isEmpty()? String.join(" ", splitedSearch) : null;

        switch (ContestStartTimeFilter.valueOf(startTimeFilter)) {
            case UPCOMING -> {
                return contestJpaRepository.findAllUpcomingContestsContainsSearchName(
                                searchName,
                                searchExcludeFinalWord,
                                searchFinalWord,
                                now,
                                isAdmin,
                                orgId,
                                isOrgAdmin,
                                paging)
                        .map(contestDataAccessMapper::contestProjectionToContest);
            }
            case HAPPENING -> {
                return contestJpaRepository.findAllHappeningContestsContainsSearchName(
                                searchName,
                                searchExcludeFinalWord,
                                searchFinalWord,
                                now,
                                isAdmin,
                                orgId,
                                isOrgAdmin,
                                paging)
                        .map(contestDataAccessMapper::contestProjectionToContest);
            }
            case ENDED -> {
                return contestJpaRepository.findAllEndedContestsContainsSearchName(
                                searchName,
                                searchExcludeFinalWord,
                                searchFinalWord,
                                now,
                                isAdmin,
                                orgId,
                                isOrgAdmin,
                                paging)
                        .map(contestDataAccessMapper::contestProjectionToContest);
            }
            default -> {
                return contestJpaRepository.findAllContainsSearchName(
                               searchName,
                                searchExcludeFinalWord,
                                searchFinalWord,
                                isAdmin,
                                orgId,
                                isOrgAdmin,
                                paging)
                        .map(contestDataAccessMapper::contestProjectionToContest);

            }
        }
    }

    @Override
    public Page<Contest> findAllMyContests(String searchName, UUID userId, Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size);

        List<String> splitedSearch = contestDataAccessMapper.splitWords(searchName);

        String searchFinalWord = splitedSearch != null && !splitedSearch.isEmpty()? splitedSearch.get(splitedSearch.size() - 1): null;

        if(splitedSearch != null && !splitedSearch.isEmpty())
            splitedSearch.remove(splitedSearch.size() - 1);

        String searchExcludeFinalWord =  splitedSearch != null && !splitedSearch.isEmpty()? String.join(" ", splitedSearch) : null;

        return contestJpaRepository.findAllMyContestsContainsSearchName(
                        searchName,
                        searchExcludeFinalWord,
                        searchFinalWord,
                        userId,
                        paging)
                .map(contestDataAccessMapper::contestProjectionToContest);
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

    @Override
    public List<PopularContestDTO> findPopularContestsBySubmissionAndParticipant() {
        return contestJpaRepository.findMostPopularContestsByParticipantAndSubmission()
                .stream()
                .map(contestDataAccessMapper::popularContestProjectionToPopularContestDTO)
                .toList();
    }
}
