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

    public Contest createContestCommandToContest(CreateContestCommand createContestCommand) {
        return Contest.builder()
                .name(createContestCommand.getName())
                .description(createContestCommand.getDescription())
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
                .build();
    }

    public CreateContestResponse contestToCreateContestResponse(Contest contest, String message) {
        return CreateContestResponse.builder()
                .contest(contest)
                .message(message)
                .build();
    }

}
