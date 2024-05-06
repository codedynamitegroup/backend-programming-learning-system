package com.backend.programming.learning.system.code.assessment.service.domain.mapper.shared_solution;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.CreateSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.CreateSharedSolutionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionResponseItem;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.SharedSolution;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.User;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class SharedSolutionDataMapper {
    public SharedSolution createSharedSolutionCommandToSharedSolution(CreateSharedSolutionCommand command) {
        return SharedSolution.builder()
                .user(User.builder().id(new UserId(command.getUserId())).build())
                .codeQuestionId(new CodeQuestionId(command.getCodeQuestionId()))
                .title(command.getTitle())
                .content(command.getContent())
                .build();
    }

    public CreateSharedSolutionResponse sharedSolutionToCreateSharedSolutionResponse(SharedSolution sharedSolution) {
        return CreateSharedSolutionResponse.builder()
                .message("create successfully")
                .sharedSolutionId(sharedSolution.getId().getValue())
                .build();
    }

    public GetSharedSolutionResponseItem sharedSolutionToGetSharedSolutionResponseItem(SharedSolution sharedSolutions, Integer totalVote) {
        return GetSharedSolutionResponseItem.builder()
                .user(GetSharedSolutionResponseItem.User.builder()
                        .id(sharedSolutions.getUser().getId().getValue())
                        .avatarUrl(sharedSolutions.getUser().getAvatarUrl())
                        .build())
                .totalVote(totalVote)
                .totalView(sharedSolutions.getViewNumber())
                .totalComment(0)
                .createdAt(sharedSolutions.getCreatedAt())
                .content(sharedSolutions.getContent())
                .title(sharedSolutions.getTitle())
                .tags(sharedSolutions.getTags()
                        .stream()
                        .map(item-> GetSharedSolutionResponseItem.Tag.builder()
                                .name(item.getName()).id(item.getId().getValue()).build())
                        .toList())
                .build();
    }

    public GetSharedSolutionResponseItem sharedSolutionToGetSharedSolutionResponseItemIgnoreTitleAndContent(SharedSolution sharedSolution) {
        return GetSharedSolutionResponseItem.builder()
                .user(GetSharedSolutionResponseItem.User.builder()
                        .id(sharedSolution.getUser().getId().getValue())
                        .avatarUrl(sharedSolution.getUser().getAvatarUrl())
                        .build())
                .totalView(sharedSolution.getViewNumber())
                .totalComment(0)
                .createdAt(sharedSolution.getCreatedAt())
                .tags(sharedSolution.getTags()
                        .stream()
                        .map(item-> GetSharedSolutionResponseItem.Tag.builder()
                                .name(item.getName()).id(item.getId().getValue()).build())
                        .toList())
                .build();
    }
}
