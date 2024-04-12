package com.backend.programming.learning.system.core.service.dataaccess.contest_user.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.contest_user.mapper.ContestUserDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.contest_user.repository.ContestUserJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestUserRepository;
import org.springframework.stereotype.Component;

@Component
public class ContestUserRepositoryImpl implements ContestUserRepository {
    private final ContestUserJpaRepository contestUserJpaRepository;
    private final ContestUserDataAccessMapper contestUserDataAccessMapper;

    public ContestUserRepositoryImpl(ContestUserJpaRepository contestUserJpaRepository, ContestUserDataAccessMapper contestUserDataAccessMapper) {
        this.contestUserJpaRepository = contestUserJpaRepository;
        this.contestUserDataAccessMapper = contestUserDataAccessMapper;
    }

    @Override
    public ContestUser saveContestUser(ContestUser contestUser) {
        return contestUserDataAccessMapper.contestUserEntityToContestUser(
                contestUserJpaRepository.save(
                        contestUserDataAccessMapper.contestUserToContestUserEntity(contestUser)
                )
        );
    }
}
