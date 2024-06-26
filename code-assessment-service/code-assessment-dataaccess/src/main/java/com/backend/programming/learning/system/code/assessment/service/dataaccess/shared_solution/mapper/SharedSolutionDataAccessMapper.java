package com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.mapper;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.CodeQuestionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.SharedSolutionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.tag.SharedSolutionTagEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.tag.entity.TagEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.SharedSolution;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.SharedSolutionVote;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Tag;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.SharedSolutionId;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SharedSolutionDataAccessMapper {
    final UserDataAccessMapper userDataAccessMapper;
    final SharedSolutionFieldToSharedSolutionEntityField sharedSolutionFieldToSharedSolutionEntityField;

    public SharedSolutionDataAccessMapper(UserDataAccessMapper userDataAccessMapper, SharedSolutionFieldToSharedSolutionEntityField sharedSolutionFieldToSharedSolutionEntityField) {
        this.userDataAccessMapper = userDataAccessMapper;
        this.sharedSolutionFieldToSharedSolutionEntityField = sharedSolutionFieldToSharedSolutionEntityField;
    }

    public String sharedSolutionFieldToSharedSolutionEntityField(String str){
        return sharedSolutionFieldToSharedSolutionEntityField.fieldMapper.get(str);
    }

    public SharedSolutionEntity sharedSoltionToEntity(SharedSolution sharedSolution) {
        return SharedSolutionEntity.builder()
                .id(sharedSolution.getId().getValue())
                .user(UserEntity.builder().id(sharedSolution.getUser().getId().getValue()).build())
                .codeQuestion(CodeQuestionEntity.builder().id(sharedSolution.getCodeQuestionId().getValue()).build())
                .title(sharedSolution.getTitle())
                .content(sharedSolution.getContent())
                .createdAt(sharedSolution.getCreatedAt())
                .updatedAt(sharedSolution.getUpdatedAt())
                .viewNumber(sharedSolution.getViewNumber())
                .build();
    }

    public SharedSolution entityToSharedSolution(SharedSolutionEntity entity, List<Tag> tags) {
        return SharedSolution.builder()
                .id(new SharedSolutionId(entity.getId()))
                .codeQuestionId(new CodeQuestionId(entity.getCodeQuestion().getId()))
                .user(userDataAccessMapper.userEntityToUser(entity.getUser()))
                .title(entity.getTitle())
                .content(entity.getContent())
                .viewNumber(entity.getViewNumber())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .totalVote(entity.getTotalVoteCount())
                .totalComment(entity.getTotalComment())
                .tags(tags)
                .build();

    }
    public SharedSolution entityToSharedSolutionIgnoreLazy(SharedSolutionEntity entity) {
        return SharedSolution.builder()
                .id(new SharedSolutionId(entity.getId()))
                .codeQuestionId(new CodeQuestionId(entity.getCodeQuestion().getId()))
                .user(userDataAccessMapper.userEntityToUser(entity.getUser()))
                .title(entity.getTitle())
                .content(entity.getContent())
                .viewNumber(entity.getViewNumber())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();

    }
    public SharedSolution entityToSharedSolution(SharedSolutionEntity entity, List<Tag> tags, SharedSolutionVote youVote) {
        return SharedSolution.builder()
                .id(new SharedSolutionId(entity.getId()))
                .codeQuestionId(new CodeQuestionId(entity.getCodeQuestion().getId()))
                .user(userDataAccessMapper.userEntityToUser(entity.getUser()))
                .title(entity.getTitle())
                .content(entity.getContent())
                .viewNumber(entity.getViewNumber())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .tags(tags)
                .totalVote(entity.getTotalVoteCount())
                .totalComment(entity.getTotalComment())
                .youVote(youVote != null? youVote.getVoteType(): null)
                .build();
    }

    public SharedSolutionTagEntity tagToSharedSolutionTagEntity(Tag tag, SharedSolutionEntity sharedSolutionEntity) {
        return SharedSolutionTagEntity.builder()
//                .sharedSolutionId(sharedSolutionEntity.getId())
//                .tagId(tag.getId().getValue())
                .sharedSolution(sharedSolutionEntity)
                .tag(TagEntity.builder().id(tag.getId().getValue()).name(tag.getName()).build())
//                .tag(tag.getId().getValue())
                .build();
    }

}
