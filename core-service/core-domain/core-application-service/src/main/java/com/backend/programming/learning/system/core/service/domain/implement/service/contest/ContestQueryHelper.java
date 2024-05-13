package com.backend.programming.learning.system.core.service.domain.implement.service.contest;

import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.ContestNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestQuestionRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestStartTimeFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ContestQueryHelper {
    private final ContestRepository contestRepository;
    private final ContestQuestionRepository contestQuestionRepository;

    public ContestQueryHelper(ContestRepository contestRepository,
                              ContestQuestionRepository contestQuestionRepository) {
        this.contestRepository = contestRepository;
        this.contestQuestionRepository = contestQuestionRepository;
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
        List<ContestQuestion> contestQuestions = getAllContestQuestionsForContest(contestId);
        List<Question> questions = contestQuestions.stream()
                .map(ContestQuestion::getQuestion)
                .toList();

        Contest contest = contestResult.get();
        contest.setQuestions(questions);

        log.info("Contest queried with id: {}", contest.getId().getValue());
        return contest;
    }

    @Transactional(readOnly = true)
    public Page<Contest> queryAllContests(
            String searchName, String startTimeFilter, Integer pageNo, Integer pageSize
    ) {
        log.info("Querying all contests with searchName: {}, startTimeFilter: {}, pageNo: {}, pageSize: {}",
                searchName, startTimeFilter, pageNo, pageSize);

        return contestRepository.findAll(searchName, startTimeFilter, pageNo, pageSize);
    }

    @Transactional(readOnly = true)
    public List<Contest> findMostPopularContests() {
        log.info("Querying most popular upcoming contests");
        return contestRepository.findMostPopularContests();
    }

    private List<ContestQuestion> getAllContestQuestionsForContest(UUID contestId) {
        List<ContestQuestion> contestQuestion = contestQuestionRepository
                .findAllContestQuestionsByContestId(contestId);

        log.info("All questions queried for contest with id: {}", contestId);
        return contestQuestion;
    }
}





















