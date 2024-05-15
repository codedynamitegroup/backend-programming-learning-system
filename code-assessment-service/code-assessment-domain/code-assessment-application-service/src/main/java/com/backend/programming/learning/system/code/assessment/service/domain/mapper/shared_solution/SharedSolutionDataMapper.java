package com.backend.programming.learning.system.code.assessment.service.domain.mapper.shared_solution;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.TagDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.UserDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.shared_solution.CreateSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.shared_solution.CreateSharedSolutionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.vote.VoteSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionResponseItem;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution.GetSharedSolutionsResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.shared_solution.UpdateSharedSolutionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.SharedSolution;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.SharedSolutionVote;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.User;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.SharedSolutionId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.shared_solution_vote.SharedSolutionVoteId;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.data.domain.Page;
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

    public GetSharedSolutionResponseItem sharedSolutionToGetSharedSolutionResponseItem(SharedSolution sharedSolution) {
        return GetSharedSolutionResponseItem.builder()
                .user(UserDto.builder()
                        .id(sharedSolution.getUser().getId().getValue())
                        .avatarUrl(sharedSolution.getUser().getAvatarUrl())
                        .firstName(sharedSolution.getUser().getFirstName())
                        .lastName(sharedSolution.getUser().getLastName())
                        .build())
                .sharedSolutionId(sharedSolution.getId().getValue())
                .totalVote(sharedSolution.getTotalVote())
                .totalView(sharedSolution.getViewNumber())
                .totalComment(sharedSolution.getTotalComment())
                .createdAt(sharedSolution.getCreatedAt())
                .content(sharedSolution.getContent())
                .title(sharedSolution.getTitle())
                .youVote(sharedSolution.getYouVote())
                .tags(sharedSolution.getTags()
                        .stream()
                        .map(item-> TagDto.builder()
                                .name(item.getName()).id(item.getId().getValue()).build())
                        .toList())
                .build();
    }

    public GetSharedSolutionResponseItem sharedSolutionToGetSharedSolutionResponseItemIgnoreContent(SharedSolution sharedSolution) {
        return GetSharedSolutionResponseItem.builder()
                .user(UserDto.builder()
                        .id(sharedSolution.getUser().getId().getValue())
                        .avatarUrl(sharedSolution.getUser().getAvatarUrl())
                        .firstName(sharedSolution.getUser().getFirstName())
                        .lastName(sharedSolution.getUser().getLastName())
                        .build())
                .sharedSolutionId(sharedSolution.getId().getValue())
                .totalView(sharedSolution.getViewNumber())
                .totalComment(0)
                .totalVote(sharedSolution.getTotalVote())
                .createdAt(sharedSolution.getCreatedAt())
                .title(sharedSolution.getTitle())
                .tags(sharedSolution.getTags()
                        .stream()
                        .map(item-> TagDto.builder()
                                .name(item.getName()).id(item.getId().getValue()).build())
                        .toList())
                .build();
    }

    public SharedSolutionVote voteSharedSolutionCommandToSharedSolutionVote(VoteSharedSolutionCommand command) {
        return SharedSolutionVote.builder()
                .id(new SharedSolutionVoteId
                        (new UserId(command.getUserId()),
                                new SharedSolutionId(command.getSharedSolutionId())))
                .voteType(command.getVoteType())
                .build();
    }

    public GetSharedSolutionsResponse pageableSharedSolutionListToGetSharedSolutionsResponse(Page<SharedSolution> sharedSolutions) {
        return GetSharedSolutionsResponse.builder()
                .currentPage(sharedSolutions.getNumber())
                .totalItems(sharedSolutions.getTotalElements())
                .totalPages(sharedSolutions.getTotalPages())
                .sharedSolution(sharedSolutions.stream().map(this::sharedSolutionToGetSharedSolutionResponseItemIgnoreContent).toList())
                .build();
    }

    public SharedSolution updateSharedSolutionCommandToSharedSolution(UpdateSharedSolutionCommand command) {
        return SharedSolution.builder()
                .id(new SharedSolutionId(command.getSharedSolutionId()))
                .content(command.getContent())
                .title(command.getTitle())
                .build();
    }
}
