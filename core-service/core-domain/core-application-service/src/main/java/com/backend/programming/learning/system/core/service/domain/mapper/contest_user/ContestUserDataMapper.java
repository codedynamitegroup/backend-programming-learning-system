package com.backend.programming.learning.system.core.service.domain.mapper.contest_user;

import com.backend.programming.learning.system.core.service.domain.dto.create.contest_user.CreateContestUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest_user.CreateContestUserResponse;
import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class ContestUserDataMapper {
    public ContestUser createContestUserCommandToContestUser(
            CreateContestUserCommand createContestUserCommand) {
        return ContestUser.builder()
                .contestId(new ContestId(createContestUserCommand.getContestId()))
                .userId(new UserId(createContestUserCommand.getUserId()))
                .isCompleted(false)
                .build();
    }

    public CreateContestUserResponse contestUserToCreateContestUserResponse(
            ContestUser contestUser, String message) {
        return CreateContestUserResponse.builder()
                .contestUserId(contestUser.getId())
                .message(message)
                .build();
    }
}
