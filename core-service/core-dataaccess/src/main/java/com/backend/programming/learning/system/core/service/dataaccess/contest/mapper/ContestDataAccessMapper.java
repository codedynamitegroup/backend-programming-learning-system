package com.backend.programming.learning.system.core.service.dataaccess.contest.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.contest.entity.ContestEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import org.springframework.stereotype.Component;

@Component
public class ContestDataAccessMapper {
    private final UserDataAccessMapper userDataAccessMapper;

    public ContestDataAccessMapper(UserDataAccessMapper userDataAccessMapper) {
        this.userDataAccessMapper = userDataAccessMapper;
    }

    public ContestEntity contestToContestEntity(Contest contest) {
        UserEntity createdBy = userDataAccessMapper.userToUserEntity(contest.getCreatedBy());
        UserEntity updatedBy = userDataAccessMapper.userToUserEntity(contest.getUpdatedBy());

        return ContestEntity.builder()
                .id(contest.getId().getValue())
                .name(contest.getName())
                .description(contest.getDescription())
                .startTime(contest.getStartTime())
                .endTime(contest.getEndTime())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .createdAt(contest.getCreatedAt())
                .updatedAt(contest.getUpdatedAt())
                .build();
    }

    public Contest contestEntityToContest(ContestEntity contestEntity) {
        User createdBy = userDataAccessMapper.userEntityToUser(contestEntity.getCreatedBy());
        User updatedBy = userDataAccessMapper.userEntityToUser(contestEntity.getUpdatedBy());
        return Contest.builder()
                .id(new ContestId(contestEntity.getId()))
                .name(contestEntity.getName())
                .description(contestEntity.getDescription())
                .startTime(contestEntity.getStartTime())
                .endTime(contestEntity.getEndTime())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .createdAt(contestEntity.getCreatedAt())
                .updatedAt(contestEntity.getUpdatedAt())
                .build();
    }
}
