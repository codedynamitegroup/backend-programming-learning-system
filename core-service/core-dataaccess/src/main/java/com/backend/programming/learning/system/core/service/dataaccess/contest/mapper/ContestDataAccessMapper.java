package com.backend.programming.learning.system.core.service.dataaccess.contest.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.contest.entity.ContestEntity;
import com.backend.programming.learning.system.core.service.dataaccess.contest.projection.ContestProjection;
import com.backend.programming.learning.system.core.service.dataaccess.contest.projection.PopularContestDataAccessDTO;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.contest.PopularContestDTO;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ContestDataAccessMapper {
    private final UserDataAccessMapper userDataAccessMapper;

    public ContestDataAccessMapper(UserDataAccessMapper userDataAccessMapper) {
        this.userDataAccessMapper = userDataAccessMapper;
    }

    public ContestEntity contestToContestEntity(Contest contest) {
        UserEntity createdBy = userDataAccessMapper.userToUserEntityHideSensitiveData(contest.getCreatedBy());
        UserEntity updatedBy = userDataAccessMapper.userToUserEntityHideSensitiveData(contest.getUpdatedBy());

        return ContestEntity.builder()
                .id(contest.getId().getValue())
                .name(contest.getName())
                .description(contest.getDescription())
                .prizes(contest.getPrizes())
                .rules(contest.getRules())
                .scoring(contest.getScoring())
                .thumbnailUrl(contest.getThumbnailUrl())
                .startTime(contest.getStartTime())
                .endTime(contest.getEndTime())
                .isPublic(contest.getPublic())
                .isRestrictedForum(contest.getRestrictedForum())
                .isDisabledForum(contest.getDisabledForum())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .createdAt(contest.getCreatedAt())
                .updatedAt(contest.getUpdatedAt())
                .build();
    }

    public Contest contestEntityToContest(ContestEntity contestEntity) {
        User createdBy = userDataAccessMapper.userEntityToUserHideSensitiveData(contestEntity.getCreatedBy());
        User updatedBy = userDataAccessMapper.userEntityToUserHideSensitiveData(contestEntity.getUpdatedBy());
        return Contest.builder()
                .id(new ContestId(contestEntity.getId()))
                .name(contestEntity.getName())
                .description(contestEntity.getDescription())
                .prizes(contestEntity.getPrizes())
                .rules(contestEntity.getRules())
                .scoring(contestEntity.getScoring())
                .thumbnailUrl(contestEntity.getThumbnailUrl())
                .startTime(contestEntity.getStartTime())
                .endTime(contestEntity.getEndTime())
                .isPublic(contestEntity.getIsPublic())
                .isRestrictedForum(contestEntity.getIsRestrictedForum())
                .isDisabledForum(contestEntity.getIsDisabledForum())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .createdAt(contestEntity.getCreatedAt())
                .updatedAt(contestEntity.getUpdatedAt())
                .build();
    }

    public Contest contestProjectionToContest(ContestProjection contestProjection) {
        ZonedDateTime startTime = contestProjection.getStartTime() == null
                ? null
                : ZonedDateTime.ofInstant(contestProjection.getStartTime(), ZoneId.of("UTC"));
        ZonedDateTime endTime = contestProjection.getEndTime() == null
                ? null
                : ZonedDateTime.ofInstant(contestProjection.getEndTime(), ZoneId.of("UTC"));
        ZonedDateTime createdAt = contestProjection.getCreatedAt() == null
                ? null
                : ZonedDateTime.ofInstant(contestProjection.getCreatedAt(), ZoneId.of("UTC"));
        ZonedDateTime updatedAt = contestProjection.getUpdatedAt() == null
                ? null
                : ZonedDateTime.ofInstant(contestProjection.getUpdatedAt(), ZoneId.of("UTC"));

        return Contest.builder()
                .id(new ContestId(contestProjection.getId()))
                .name(contestProjection.getName())
                .description(contestProjection.getDescription())
                .prizes(contestProjection.getPrizes())
                .rules(contestProjection.getRules())
                .scoring(contestProjection.getScoring())
                .thumbnailUrl(contestProjection.getThumbnailUrl())
                .startTime(startTime)
                .endTime(endTime)
                .isPublic(contestProjection.getIsPublic())
                .isRestrictedForum(contestProjection.getIsRestrictedForum())
                .isDisabledForum(contestProjection.getIsDisabledForum())
                .numOfParticipants(contestProjection.getNumOfParticipants())
                .createdBy(User.builder()
                        .id(new UserId(contestProjection.getCreatedById()))
                        .build())
                .updatedBy(User.builder()
                        .id(new UserId(contestProjection.getUpdatedById()))
                        .build())
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }

    public List<String> splitWords(String search) {
        if(search == null) return null;

        ArrayList<String> words = Stream.of(search.split(" ")).filter(i-> !i.isEmpty()).collect(Collectors.toCollection(ArrayList::new));

        return words;
    }

    public PopularContestDTO popularContestProjectionToPopularContestDTO(PopularContestDataAccessDTO popularContestDataAccessDTO) {
        ZonedDateTime createdAt = popularContestDataAccessDTO.getCreatedAt() == null
                ? null
                : ZonedDateTime.ofInstant(popularContestDataAccessDTO.getCreatedAt(), ZoneId.of("UTC"));
        ZonedDateTime updatedAt = popularContestDataAccessDTO.getUpdatedAt() == null
                ? null
                : ZonedDateTime.ofInstant(popularContestDataAccessDTO.getUpdatedAt(), ZoneId.of("UTC"));
        ZonedDateTime startTime = popularContestDataAccessDTO.getStartTime() == null
                ? null
                : ZonedDateTime.ofInstant(popularContestDataAccessDTO.getStartTime(), ZoneId.of("UTC"));
        ZonedDateTime endTime = popularContestDataAccessDTO.getEndTime() == null
                ? null
                : ZonedDateTime.ofInstant(popularContestDataAccessDTO.getEndTime(), ZoneId.of("UTC"));

        return PopularContestDTO.builder()
                .id(popularContestDataAccessDTO.getId())
                .contestName(popularContestDataAccessDTO.getContestName())
                .totalParticipants(popularContestDataAccessDTO.getTotalParticipants())
                .totalSubmissions(popularContestDataAccessDTO.getTotalSubmissions())
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .startTime(startTime)
                .endTime(endTime)
                .build();
    }
}
