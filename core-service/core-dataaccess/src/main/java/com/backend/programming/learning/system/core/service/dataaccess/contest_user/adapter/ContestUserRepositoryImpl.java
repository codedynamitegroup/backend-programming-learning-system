package com.backend.programming.learning.system.core.service.dataaccess.contest_user.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.contest_user.mapper.ContestUserDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.contest_user.repository.ContestUserJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.ContestQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public Page<ContestUser> findAllByContestId(UUID contestId, Integer pageNo, Integer pageSize, Boolean fetchAll) {
        Pageable paging = fetchAll ? Pageable.unpaged() : Pageable.ofSize(pageSize).withPage(pageNo);
        return contestUserJpaRepository.findAllByContestId(contestId, paging)
                .map(contestUserDataAccessMapper::contestUserEntityToContestUser);
    }

    @Override
    public Optional<ContestUser> findByContestIdAndUserId(UUID contestId, UUID userId) {
        return contestUserJpaRepository.findByContestIdAndUserId(contestId, userId)
                .map(contestUserDataAccessMapper::contestUserEntityToContestUser);
    }

    @Override
    public List<ContestUser> findByContestId(UUID contestId) {
        return contestUserDataAccessMapper.contestUserEntityListToContestUserList(
                contestUserJpaRepository.findByContestId(contestId)
        );
    }

    @Override
    public void deleteByContestIdAndUserId(UUID contestId, UUID userId) {
        contestUserJpaRepository.deleteByContestIdAndUserId(contestId, userId);
    }

    @Override
    public int countAllParticipants() {
        return contestUserJpaRepository.countAllParticipants();
    }

    @Override
    public Page<ContestUser> findAllContestUsersOfLeaderboard(UUID contestId, Integer pageNo, Integer pageSize) {
        Pageable paging = Pageable.ofSize(pageSize).withPage(pageNo);
        return contestUserJpaRepository.findAllContestUsersOfLeaderboard(contestId, paging)
                .map(contestUserDataAccessMapper::contestUserEntityToContestUser);
    }

    @Override
    public Optional<ContestUser> findMyRankOfContest(UUID userId, UUID contestId) {
        return contestUserJpaRepository.findMyRankOfLeaderboard(userId, contestId)
                .map(contestUserDataAccessMapper::contestUserEntityToContestUser);
    }
}
