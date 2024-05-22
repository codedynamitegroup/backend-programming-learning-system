package com.backend.programming.learning.system.core.service.domain.mapper.contest;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest.CreateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest.CreateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryAllContestsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.contest.UpdateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest_question.ContestQuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest_user.ContestUserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest.ContestResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.ContestQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContestDataMapper {
    private final UserDataMapper userDataMapper;
    private final QuestionDataMapper questionDataMapper;

    public ContestDataMapper(UserDataMapper userDataMapper,
                             QuestionDataMapper questionDataMapper) {
        this.userDataMapper = userDataMapper;
        this.questionDataMapper = questionDataMapper;
    }

    public Contest createContestCommandToContest(CreateContestCommand createContestCommand) {
        return Contest.builder()
                .name(createContestCommand.getName())
                .description(createContestCommand.getDescription())
                .thumbnailUrl(createContestCommand.getThumbnailUrl())
                .startTime(createContestCommand.getStartTime())
                .endTime(createContestCommand.getEndTime())
                .createdBy(User
                        .builder()
                        .id(new UserId(createContestCommand.getCreatedBy()))
                        .build())
                .updatedBy(User
                        .builder()
                        .id(new UserId(createContestCommand.getUpdatedBy()))
                        .build())
                .createdAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .updatedAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .build();
    }

    public CreateContestResponse contestToCreateContestResponse(Contest contest, String message) {
        return CreateContestResponse.builder()
                .contestId(contest.getId().getValue())
                .name(contest.getName())
                .message(message)
                .build();
    }

    public ContestResponseEntity contestToQueryContestResponse(Contest contest) {
        UserResponseEntity createdByResponse = userDataMapper.userToUserResponseEntity(contest.getCreatedBy());
        UserResponseEntity updatedByResponse = userDataMapper.userToUserResponseEntity(contest.getUpdatedBy());
        List<QuestionResponseEntity> questionResponseEntities =
                contest.getQuestions().stream()
                        .map(questionDataMapper::questionToQuestionResponseEntity)
                        .toList();

        return ContestResponseEntity.builder()
                .contestId(contest.getId().getValue())
                .name(contest.getName())
                .description(contest.getDescription())
                .thumbnailUrl(contest.getThumbnailUrl())
                .questions(questionResponseEntities)
                .startTime(contest.getStartTime())
                .endTime(contest.getEndTime())
                .isRegistered(contest.getRegistered())
                .createdBy(createdByResponse)
                .updatedBy(updatedByResponse)
                .createdAt(contest.getCreatedAt())
                .updatedAt(contest.getUpdatedAt())
                .build();
    }

    public QueryAllContestsResponse contestsToQueryAllContestsResponse(Page<Contest> contests) {
        return QueryAllContestsResponse.builder()
                .contests(contests.stream()
                        .map(this::contestToQueryContestResponse)
                        .collect(Collectors.toList()))
                .currentPage(contests.getNumber())
                .totalPages(contests.getTotalPages())
                .totalItems(contests.getTotalElements())
                .build();
    }

    public UpdateContestResponse contestToUpdateContestResponse(ContestId contestId, String message) {
        return UpdateContestResponse.builder()
                .contestId(contestId.getValue())
                .message(message)
                .build();
    }


    public List<ContestResponseEntity> contestsToContestResponseEntities(List<Contest> contests) {
        return contests.stream()
                .map(this::contestToQueryContestResponse)
                .collect(Collectors.toList());
    }

    public List<ContestUserResponseEntity> contestUsersToContestUserResponseEntities(List<ContestUser> contestUsers) {
        return contestUsers.stream()
                .map(this::contestUserToContestUserResponseEntity)
                .collect(Collectors.toList());
    }

    public ContestUserResponseEntity contestUserToContestUserResponseEntity(ContestUser contestUser) {
        UserResponseEntity userResponseEntity = userDataMapper.userToUserResponseEntity(contestUser.getUser());
        List<ContestQuestionResponseEntity> contestQuestionResponseEntities = new ArrayList<>();
        for (int i = 0; i < contestUser.getContestQuestions().size(); i++) {
            ContestQuestion contestQuestion = contestUser.getContestQuestions().get(i);
            ContestQuestionResponseEntity contestQuestionResponseEntity = ContestQuestionResponseEntity.builder()
                    .questionId(contestQuestion.getQuestion().getId().getValue())
                    .codeQuestionId(contestQuestion.getCodeQuestionId())
                    .difficulty(contestQuestion.getQuestion().getDifficulty())
                    .name(contestQuestion.getQuestion().getName())
                    .questionText(contestQuestion.getQuestion().getQuestionText())
                    .defaultMark(contestQuestion.getQuestion().getDefaultMark())
                    .maxGrade(contestQuestion.getMaxGrade())
                    .grade(contestQuestion.getGrade())
                    .doTime(contestQuestion.getDoTime())
                    .numOfSubmissions(contestQuestion.getNumOfSubmissions())
                    .build();
            contestQuestionResponseEntities.add(contestQuestionResponseEntity);
        }

        return ContestUserResponseEntity.builder()
                .contestId(contestUser.getContest().getId().getValue())
                .user(userResponseEntity)
                .rank(contestUser.getRank())
                .totalTime(contestUser.getTotalTime())
                .totalScore(contestUser.getTotalScore())
                .contestQuestions(contestQuestionResponseEntities)
                .calendarEventId(contestUser.getCalendarEventId())
                .isCompleted(contestUser.getCompleted())
                .completedAt(contestUser.getCompletedAt())
                .createdAt(contestUser.getCreatedAt())
                .updatedAt(contestUser.getUpdatedAt())
                .build();
    }
}
