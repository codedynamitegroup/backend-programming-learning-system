package com.backend.programming.learning.system.course.service.domain.implement.service.rubric_user;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.rubric_user.CreateRubricUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.user.CreateUserResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.rubric_user.QueryAllRubricsByUserIdCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.rubric_user.QueryAllRubricsByUserIdResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.rubric_user.UpdateRubricUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.user.UpdateUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.user.UpdateUserResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.user.UserSubmissionAssignmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.RubricUser;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.implement.service.user.UserCommandHandler;
import com.backend.programming.learning.system.course.service.domain.mapper.rubric_user.RubricUserDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.rubric_user.RubricUserApplicationService;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.user.UserApplicationService;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.RubricUserRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Slf4j
@Validated
@Service
@RequiredArgsConstructor
class RubricUserApplicationServiceImpl implements RubricUserApplicationService {
    private final RubricUserRepository rubricUserRepository;
    private final RubricUserDataMapper rubricUserDataMapper;
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public QueryAllRubricsByUserIdResponse queryAllRubricsByUserId(QueryAllRubricsByUserIdCommand queryAllRubricsByUserIdCommand) {
        Page<RubricUser> rubricUsers = rubricUserRepository.findAllByUserId(queryAllRubricsByUserIdCommand.getUserId(), queryAllRubricsByUserIdCommand.getPageNo(), queryAllRubricsByUserIdCommand.getPageSize(), queryAllRubricsByUserIdCommand.getSearch());
        return rubricUserDataMapper.rubricUsersToQueryAllRubricsByUserId(rubricUsers);
    }

    @Override
    @Transactional
    public void createRubricUser(CreateRubricUserCommand createRubricUserCommand) {
        RubricUser rubricUser = rubricUserDataMapper.createRubricUserCommandToRubricUser(createRubricUserCommand);
        User user = findUserById(UUID.fromString(createRubricUserCommand.getUserId()));
        rubricUser.setUser(user);
        rubricUser.initializeRubricUser();

        rubricUserRepository.save(rubricUser);
    }

    @Override
    @Transactional
    public void updateRubricUser(UpdateRubricUserCommand updateRubricUserCommand) {
        RubricUser rubricUser = findRubricUserById(UUID.fromString(updateRubricUserCommand.getRubricUserId()));
        if (updateRubricUserCommand.getRubricContent() != null) {
            rubricUser.setContent(updateRubricUserCommand.getRubricContent());
        }
        if (updateRubricUserCommand.getRubricName() != null) {
            rubricUser.setName(updateRubricUserCommand.getRubricName());
        }
        if (updateRubricUserCommand.getRubricDescription() != null) {
            rubricUser.setDescription(updateRubricUserCommand.getRubricDescription());
        }
        rubricUserRepository.save(rubricUser);
    }

    @Override
    @Transactional
    public void deleteRubricUser(UUID rubricUserId) {
        RubricUser rubricUser = findRubricUserById(rubricUserId);
        rubricUserRepository.deleteById(rubricUser.getId().getValue());
    }

    public User findUserById(UUID userId) {
        return userRepository.findById(new UserId(userId)).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public RubricUser findRubricUserById(UUID rubricUserId) {
        return rubricUserRepository.findRubricUser(rubricUserId).orElseThrow(() -> new RuntimeException("Rubric user not found"));
    }
}
