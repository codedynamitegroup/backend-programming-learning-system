package com.backend.programming.learning.system.course.service.dataaccess.rubric_user.mapper;


import com.backend.programming.learning.system.course.service.dataaccess.assignment_ai_grade_report.entity.AssignmentAIGradeReportEntity;
import com.backend.programming.learning.system.course.service.dataaccess.rubric_user.entity.RubricUserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.course.service.domain.entity.AssignmentAIGradeReport;
import com.backend.programming.learning.system.course.service.domain.entity.RubricUser;
import com.backend.programming.learning.system.course.service.domain.valueobject.AssignmentAIGradeReportId;
import com.backend.programming.learning.system.course.service.domain.valueobject.RubricUserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class RubricUserDataAccessMapper {
    private final UserDataAccessMapper userDataAccessMapper;

    public RubricUserEntity rubricUserToRubricUserEntity(RubricUser rubricUser) {
        return RubricUserEntity.builder()
                .id(rubricUser.getId().getValue())
                .content(rubricUser.getContent())
                .user(rubricUser.getUser() == null ? null : userDataAccessMapper.userToUserEntity(rubricUser.getUser()))
                .name(rubricUser.getName())
                .description(rubricUser.getDescription())
                .build();
    }

    public RubricUser rubricUserEntityToRubricUser(RubricUserEntity rubricUserEntity) {
        return RubricUser.builder()
                .id(new RubricUserId(rubricUserEntity.getId()))
                .content(rubricUserEntity.getContent())
                .user(rubricUserEntity.getUser() == null ? null : userDataAccessMapper.userEntityToUser(rubricUserEntity.getUser()))
                .name(rubricUserEntity.getName())
                .description(rubricUserEntity.getDescription())
                .build();

    }
}
