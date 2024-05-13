package com.backend.programming.learning.system.code.assessment.service.domain.dto.entity;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Comment;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.ProgrammingLanguage;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.User;
import org.springframework.stereotype.Component;

@Component
public class DtoMapper {
    public CommentDto commentToCommentDto(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId().getValue())
                .content(comment.getContent())
                .numOfReply(comment.getNumOfReply())
                .totalVote(comment.getTotalVote())
                .replyId(comment.getReplyId() != null? comment.getReplyId().getValue(): null)
                .createdAt(comment.getCreatedAt())
                .user(this.userToUserDto(comment.getUser()))
                .youVote(comment.getYouVote())
                .build();
    }

    public UserDto userToUserDto(User user) {
        return UserDto.builder()
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .avatarUrl(user.getAvatarUrl())
                .id(user.getId().getValue())
                .build();
    }

    public CodeQuestionDto codeQuestionToDto(CodeQuestion codeQuestion) {
        return CodeQuestionDto.builder()
                .name(codeQuestion.getName())
                .done(codeQuestion.getSolved())
                .id(codeQuestion.getId().getValue())
                .difficulty(codeQuestion.getDifficulty())
                .build();
    }

    public ProgrammingLanguageDto programmingLanguageToDto(ProgrammingLanguage programmingLanguage) {
        return ProgrammingLanguageDto.builder()
                .isActived(programmingLanguage.getIsActive())
                .memoryLimit(programmingLanguage.getMemoryLimit())
                .judge0Id(programmingLanguage.getJudge0_compilerApiId())
                .timeLimit(programmingLanguage.getTimeLimit())
                .id(programmingLanguage.getId().getValue())
                .name(programmingLanguage.getName())
                .build();
    }
}
