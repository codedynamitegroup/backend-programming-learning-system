package com.backend.programming.learning.system.core.service.domain.implement.contest;

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
    private final UserRepository userRepository;
    private final ContestQuestionRepository contestQuestionRepository;

    public ContestQueryHelper(ContestRepository contestRepository,
                              UserRepository userRepository,
                              ContestQuestionRepository contestQuestionRepository) {
        this.contestRepository = contestRepository;
        this.userRepository = userRepository;
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
        User createdBy = getUser(contestResult.get().getCreatedBy().getId().getValue());
        User updatedBy = getUser(contestResult.get().getUpdatedBy().getId().getValue());
        List<ContestQuestion> contestQuestions = getAllContestQuestionsForContest(contestId);
        List<Question> questions = contestQuestions.stream()
                .map(ContestQuestion::getQuestion)
                .toList();

        Contest contest = contestResult.get();
        contest.setCreatedBy(createdBy);
        contest.setUpdatedBy(updatedBy);
        contest.setQuestions(questions);

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
            String searchName, String startTimeFilter, Integer pageNo, Integer pageSize
    ) {
        log.info("Querying all contests with searchName: {}, startTimeFilter: {}, pageNo: {}, pageSize: {}",
                searchName, startTimeFilter, pageNo, pageSize);
        Page<Contest> contests = contestRepository.findAll(searchName, startTimeFilter, pageNo, pageSize);

        for (Contest contest : contests) {
            User createdBy = getUser(contest.getCreatedBy().getId().getValue());
            User updatedBy = getUser(contest.getUpdatedBy().getId().getValue());
            List<ContestQuestion> contestQuestions = getAllContestQuestionsForContest(contest.getId().getValue());
            List<Question> questions = contestQuestions.stream()
                    .map(ContestQuestion::getQuestion)
                    .toList();
            contest.setCreatedBy(createdBy);
            contest.setUpdatedBy(updatedBy);
            contest.setQuestions(questions);
        }

        return contests;
    }

    private List<ContestQuestion> getAllContestQuestionsForContest(UUID contestId) {
        List<ContestQuestion> contestQuestion = contestQuestionRepository
                .findAllContestQuestionsByContestId(contestId);

        log.info("All questions queried for contest with id: {}", contestId);
        return contestQuestion;
    }
}





















