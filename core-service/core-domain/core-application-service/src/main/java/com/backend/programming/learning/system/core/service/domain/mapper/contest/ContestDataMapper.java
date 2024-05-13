package com.backend.programming.learning.system.core.service.domain.mapper.contest;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest.CreateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest.CreateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryAllContestsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.contest.UpdateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest.ContestResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.stream.Collectors;

@Component
public class ContestDataMapper {
    private final UserDataMapper userDataMapper;

    public ContestDataMapper(UserDataMapper userDataMapper) {
        this.userDataMapper = userDataMapper;
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

        return ContestResponseEntity.builder()
                .contestId(contest.getId().getValue())
                .name(contest.getName())
                .description(contest.getDescription())
                .thumbnailUrl(contest.getThumbnailUrl())
                .startTime(contest.getStartTime())
                .endTime(contest.getEndTime())
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

}
