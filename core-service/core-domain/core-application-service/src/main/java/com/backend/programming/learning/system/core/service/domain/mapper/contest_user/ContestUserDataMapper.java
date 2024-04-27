package com.backend.programming.learning.system.core.service.domain.mapper.contest_user;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest_user.CreateContestUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest_user.CreateContestUserResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryAllContestUsersResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest_user.ContestUserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.core.service.domain.valueobject.UpdateState;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ContestUserDataMapper {
    private final UserDataMapper userDataMapper;

    public ContestUserDataMapper(UserDataMapper userDataMapper) {
        this.userDataMapper = userDataMapper;
    }

    public ContestUser createContestUserCommandToContestUser(
            CreateContestUserCommand createContestUserCommand) {
        return ContestUser.builder()
                .contest(Contest.builder()
                        .id(new ContestId(createContestUserCommand.getContestId()))
                        .build())
                .user(User.builder()
                        .id(new UserId(createContestUserCommand.getUserId()))
                        .build())
                .isCompleted(false)
                .createdAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .updatedAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .build();
    }

    public CreateContestUserResponse contestUserToCreateContestUserResponse(
            ContestUser contestUser, String message) {
        return CreateContestUserResponse.builder()
                .contestId(contestUser.getContest().getId().getValue())
                .userId(contestUser.getUser().getId().getValue())
                .message(message)
                .build();
    }

    public ContestUserResponseEntity contestUserToContestUserResponseEntity(
            ContestUser contestUser) {
        return ContestUserResponseEntity.builder()
                .contestId(contestUser.getContest().getId().getValue())
                .user(userDataMapper.userToUserResponseEntity(contestUser.getUser()))
                .isCompleted(contestUser.getCompleted())
                .completedAt(contestUser.getCompletedAt())
                .createdAt(contestUser.getCreatedAt())
                .updatedAt(contestUser.getUpdatedAt())
                .build();
    }

    public QueryAllContestUsersResponse contestUsersToQueryAllContestUsersResponse(
            Page<ContestUser> contestUsers) {
        List<ContestUserResponseEntity> contestUserResponseEntities = new ArrayList<>();
        contestUsers.forEach(contestUser -> contestUserResponseEntities.add(
                contestUserToContestUserResponseEntity(contestUser)));
        return QueryAllContestUsersResponse.builder()
                .contestUsers(contestUserResponseEntities)
                .currentPage(contestUsers.getNumber())
                .totalItems(contestUsers.getTotalElements())
                .totalPages(contestUsers.getTotalPages())
                .build();
    }
}
