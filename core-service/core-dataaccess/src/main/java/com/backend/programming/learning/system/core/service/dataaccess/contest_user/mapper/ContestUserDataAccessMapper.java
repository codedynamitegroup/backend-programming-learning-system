package com.backend.programming.learning.system.core.service.dataaccess.contest_user.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.contest.entity.ContestEntity;
import com.backend.programming.learning.system.core.service.dataaccess.contest.mapper.ContestDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.contest_user.entity.ContestUserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestUserId;
import org.springframework.stereotype.Component;

import java.util.List;

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
                .rank(contestUserEntity.getRank())
                .totalTime(contestUserEntity.getTotalTime())
                .totalScore(contestUserEntity.getTotalScore())
                .isCompleted(contestUserEntity.getIsCompleted())
                .completedAt(contestUserEntity.getCompletedAt())
                .createdAt(contestUserEntity.getCreatedAt())
                .build();
    }

    public List<ContestUser> contestUserEntityListToContestUserList(
            List<ContestUserEntity> contestUserEntities) {
        return contestUserEntities.stream()
                .map(this::contestUserEntityToContestUser)
                .toList();
    }
}
