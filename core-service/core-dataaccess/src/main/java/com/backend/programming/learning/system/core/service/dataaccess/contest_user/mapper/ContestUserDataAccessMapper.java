package com.backend.programming.learning.system.core.service.dataaccess.contest_user.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.contest.entity.ContestEntity;
import com.backend.programming.learning.system.core.service.dataaccess.contest.mapper.ContestDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.contest_user.projection.ContestUserLeaderboardProjection;
import com.backend.programming.learning.system.core.service.dataaccess.contest_user.entity.ContestUserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestUserId;
import com.backend.programming.learning.system.core.service.domain.valueobject.UpdateState;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Slf4j
@Component
public class ContestUserDataAccessMapper {
    private final ContestDataAccessMapper contestDataAccessMapper;
    private final UserDataAccessMapper userDataAccessMapper;

    public ContestUserDataAccessMapper(
            ContestDataAccessMapper contestDataAccessMapper, UserDataAccessMapper userDataAccessMapper) {
        this.contestDataAccessMapper = contestDataAccessMapper;
        this.userDataAccessMapper = userDataAccessMapper;
    }

    public ContestUserEntity contestUserToContestUserEntity(ContestUser contestUser) {
        UserEntity user = userDataAccessMapper.userToUserEntityHideSensitiveData(contestUser.getUser());
        ContestEntity contest = contestDataAccessMapper.contestToContestEntity(contestUser.getContest());
        return ContestUserEntity.builder()
                .id(contestUser.getId().getValue())
                .user(user)
                .contest(contest)
                .calendarEventId(contestUser.getCalendarEventId())
                .updateCalendarEventState(contestUser.getUpdateCalendarEventState())
                .isCompleted(contestUser.getCompleted())
                .completedAt(contestUser.getCompletedAt())
                .createdAt(contestUser.getCreatedAt())
                .build();
    }

    public ContestUser contestUserEntityToContestUser(ContestUserEntity contestUserEntity) {
        User user = userDataAccessMapper.userEntityToUserHideSensitiveData(contestUserEntity.getUser());
        Contest contest = contestDataAccessMapper.contestEntityToContest(contestUserEntity.getContest());
        return ContestUser.builder()
                .id(new ContestUserId(contestUserEntity.getId()))
                .user(user)
                .contest(contest)
                .calendarEventId(contestUserEntity.getCalendarEventId())
                .updateCalendarEventState(contestUserEntity.getUpdateCalendarEventState())
                .isCompleted(contestUserEntity.getIsCompleted())
                .completedAt(contestUserEntity.getCompletedAt())
                .createdAt(contestUserEntity.getCreatedAt())
                .build();
    }

    public ContestUser contestUserLeaderboardToContestUser(ContestUserLeaderboardProjection contestUserLeaderboardProjection) {
            ZonedDateTime completedAt = contestUserLeaderboardProjection.getCompletedAt() == null
                    ? null
                    : ZonedDateTime.ofInstant(contestUserLeaderboardProjection.getCompletedAt(), ZoneId.of("UTC"));
            ZonedDateTime createdAt = contestUserLeaderboardProjection.getCreatedAt() == null
                    ? null
                    : ZonedDateTime.ofInstant(contestUserLeaderboardProjection.getCreatedAt(), ZoneId.of("UTC"));
            ZonedDateTime updatedAt = contestUserLeaderboardProjection.getUpdatedAt() == null
                    ? null
                    : ZonedDateTime.ofInstant(contestUserLeaderboardProjection.getUpdatedAt(), ZoneId.of("UTC"));
        return ContestUser.builder()
                .id(new ContestUserId(contestUserLeaderboardProjection.getId()))
                .user(User.builder()
                        .id(new UserId(contestUserLeaderboardProjection.getUserId()))
                        .build())
                .contest(Contest.builder()
                        .id(new ContestId(contestUserLeaderboardProjection.getContestId()))
                        .build())
                .calendarEventId(contestUserLeaderboardProjection.getCalendarEventId())
                .updateCalendarEventState(
                        contestUserLeaderboardProjection.getUpdateCalendarEventState() == null
                                ? null
                                : UpdateState.valueOf(contestUserLeaderboardProjection.getUpdateCalendarEventState())
                )
                .isCompleted(contestUserLeaderboardProjection.getIsCompleted())
                .completedAt(completedAt)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .rank(contestUserLeaderboardProjection.getRank())
                .totalScore(contestUserLeaderboardProjection.getTotalScore())
                .totalTime(contestUserLeaderboardProjection.getTotalTime())
                .build();
    }

    public List<ContestUser> contestUserEntityListToContestUserList(
            List<ContestUserEntity> contestUserEntities) {
        return contestUserEntities.stream()
                .map(this::contestUserEntityToContestUser)
                .toList();
    }
}
