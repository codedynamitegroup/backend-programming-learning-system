package com.backend.programming.learning.system.core.service.domain.implement.service.contest;

import com.backend.programming.learning.system.core.service.domain.dto.method.update.certificatecourse.UpdateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.contest.UpdateContestCommand;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.exception.*;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.core.service.domain.valueobject.*;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.exception.question.QuestionNotFoundException;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ContestUpdateHelper {
    private final ContestRepository contestRepository;
    private final ContestQuestionRepository contestQuestionRepository;
    private final UserRepository userRepository;
    private final ContestUserRepository contestUserRepository;
    private final QuestionRepository questionRepository;

    public ContestUpdateHelper(ContestRepository contestRepository,
                               ContestQuestionRepository contestQuestionRepository,
                               UserRepository userRepository,
                               ContestUserRepository contestUserRepository,
                               QuestionRepository questionRepository) {
        this.contestRepository = contestRepository;
        this.contestQuestionRepository = contestQuestionRepository;
        this.userRepository = userRepository;
        this.contestUserRepository = contestUserRepository;
        this.questionRepository = questionRepository;
    }

    @Transactional
    public void persistContest(UpdateContestCommand updateContestCommand) {
        Contest contest = getContest(updateContestCommand.getContestId());

        User updatedBy = findUserByEmail(updateContestCommand.getEmail());
        contest.setUpdatedBy(updatedBy);
        contest.setUpdatedAt(ZonedDateTime.now(ZoneId.of("UTC")));

        if (updateContestCommand.getName() != null) {
            contest.setName(updateContestCommand.getName());
        }

        if (updateContestCommand.getDescription() != null) {
            contest.setDescription(updateContestCommand.getDescription());
        }

        if (updateContestCommand.getThumbnailUrl() != null) {
            contest.setThumbnailUrl(updateContestCommand.getThumbnailUrl());
        }

        if (updateContestCommand.getPrizes() != null) {
            contest.setPrizes(updateContestCommand.getPrizes());
        }

        if (updateContestCommand.getRules() != null) {
            contest.setRules(updateContestCommand.getRules());
        }

        if (updateContestCommand.getScoring() != null) {
            contest.setScoring(updateContestCommand.getScoring());
        }

        if (updateContestCommand.getIsPublic() != null) {
            contest.setPublic(updateContestCommand.getIsPublic());
        }

        if (updateContestCommand.getIsRestrictedForum() != null) {
            contest.setRestrictedForum(updateContestCommand.getIsRestrictedForum());
        }

        if (updateContestCommand.getIsDisabledForum() != null) {
            contest.setDisabledForum(updateContestCommand.getIsDisabledForum());
        }

        if (updateContestCommand.getStartTime() != null) {
            contest.setStartTime(updateContestCommand.getStartTime());
        }

        if (updateContestCommand.getEndTime() != null) {
            contest.setEndTime(updateContestCommand.getEndTime());
        }

        if (updateContestCommand.getQuestionIds() != null) {
            contestQuestionRepository.deleteAllContestQuestionsByContestId(contest.getId().getValue());

            for (UUID questionId : updateContestCommand.getQuestionIds()) {
                Optional<Question> question = questionRepository.findQuestion(questionId);
                if (question.isPresent()) {
                    ContestQuestion contestQuestion = ContestQuestion.builder()
                            .id(new ContestQuestionId(UUID.randomUUID()))
                            .contest(contest)
                            .question(question.get())
                            .build();
                    contestQuestionRepository.saveContestQuestion(contestQuestion);
                }
            }
        }

        updateContest(contest);

        log.info("Contest updated with id: {}", contest.getId().getValue());
    }

    private Contest getContest(UUID contestId) {
        Optional<Contest> contest = contestRepository.findById(new ContestId(contestId));
        if (contest.isEmpty()) {
            log.warn("Contest with id: {} not found", contestId);
            throw new ContestNotFoundException("Could not find contest with id: " + contestId);
        }
        return contest.get();
    }

    private User getUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
        return user.get();
    }

    private User findUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            log.warn("User with email: {} not found", email);
            throw new UserNotFoundException("Could not find user with email: " + email);
        }
        return user.get();
    }

    private void updateContest(Contest contest) {
        Contest updatedContest = contestRepository
                .saveContest(contest);

        if (updatedContest == null) {
            log.error("Could not update contest with id: {}", contest.getId().getValue());

            throw new CoreDomainException("Could not update contest with id: " + contest.getId().getValue());
        }
        log.info("Contest updated with id: {}", contest.getId().getValue());
    }

}





















