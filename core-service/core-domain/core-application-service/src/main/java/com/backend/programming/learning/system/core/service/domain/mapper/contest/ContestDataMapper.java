package com.backend.programming.learning.system.core.service.domain.mapper.contest;

import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.TopicNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class ContestDataMapper {
    private final UserRepository userRepository;

    public ContestDataMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Contest createContestCommandToContest(CreateContestCommand createContestCommand) {
        User createdBy = userRepository.findUser(new UserId(createContestCommand.getCreatedBy()).getValue())
                .orElseThrow(() -> new TopicNotFoundException("User not found with id: " +
                        createContestCommand.getCreatedBy()));
        User updatedBy = userRepository.findUser(new UserId(createContestCommand.getUpdatedBy()).getValue())
                .orElseThrow(() -> new TopicNotFoundException("User not found with id: " +
                        createContestCommand.getUpdatedBy()));
        return Contest.builder()
                .name(createContestCommand.getName())
                .description(createContestCommand.getDescription())
                .startTime(createContestCommand.getStartTime())
                .endTime(createContestCommand.getEndTime())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .build();
    }

    public CreateContestResponse contestToCreateContestResponse(Contest contest, String message) {
        return CreateContestResponse.builder()
                .contest(contest)
                .message(message)
                .build();
    }

}
