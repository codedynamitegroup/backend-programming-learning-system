package com.backend.programming.learning.system.course.service.domain.mapper.rubric_user;


import com.backend.programming.learning.system.course.service.domain.dto.method.create.rubric_user.CreateRubricUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.rubric_user.QueryAllRubricsByUserIdResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.rubric_user.RubricUserEntityResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.RubricUser;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.util.List;

@Component
public class RubricUserDataMapper {
    public QueryAllRubricsByUserIdResponse rubricUsersToQueryAllRubricsByUserId(Page<RubricUser> rubricUsers) {
        List<RubricUserEntityResponse> rubricUserEntityResponses = rubricUsers.getContent().stream().map(this::rubricUserToRubricUserEntityResponse).toList();
        return QueryAllRubricsByUserIdResponse.builder()
                .rubricUsers(rubricUserEntityResponses)
                .currentPage(rubricUsers.getNumber())
                .totalPages(rubricUsers.getTotalPages())
                .totalItems(rubricUsers.getTotalElements())
                .build();
    }

    public RubricUserEntityResponse rubricUserToRubricUserEntityResponse(RubricUser rubricUser) {
        return RubricUserEntityResponse.builder()
                .id(rubricUser.getId().getValue().toString())
                .content(rubricUser.getContent())
                .name(rubricUser.getName())
                .description(rubricUser.getDescription())
                .build();
    }

    public RubricUser createRubricUserCommandToRubricUser(CreateRubricUserCommand createRubricUserCommand) {
        return RubricUser.builder()
                .content(createRubricUserCommand.getRubricContent())
                .name(createRubricUserCommand.getRubricName())
                .description(createRubricUserCommand.getRubricDescription())
                .build();
    }

}
