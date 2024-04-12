package com.backend.programming.learning.system.core.service.dataaccess.contest_user.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_user.entity.CertificateCourseUserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.contest_user.entity.ContestUserEntity;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseUser;
import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestUserId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class ContestUserDataAccessMapper {

    public ContestUserEntity contestUserToContestUserEntity(ContestUser contestUser) {
        return ContestUserEntity.builder()
                .id(contestUser.getId().getValue())
                .userId(contestUser.getUserId().getValue())
                .contestId(contestUser.getContestId().getValue())
                .registeredAt(contestUser.getRegisteredAt())
                .isCompleted(contestUser.getCompleted())
                .completedAt(contestUser.getCompletedAt())
                .build();
    }

    public ContestUser contestUserEntityToContestUser(ContestUserEntity contestUserEntity) {
        return ContestUser.builder()
                .id(new ContestUserId(contestUserEntity.getId()))
                .userId(new UserId(contestUserEntity.getUserId()))
                .contestId(new ContestId(contestUserEntity.getContestId()))
                .registeredAt(contestUserEntity.getRegisteredAt())
                .isCompleted(contestUserEntity.getIsCompleted())
                .completedAt(contestUserEntity.getCompletedAt())
                .build();
    }
}
