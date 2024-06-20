package com.backend.programming.learning.system.course.service.domain.implement.service.user;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.user.UserSubmissionAssignmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserQueryHelper {
    private final UserRepository userRepository;
    @Transactional(readOnly = true)
    public List<User> queryAllUserByAssignmentId(UUID assignmentId) {
        return userRepository.findAllUserByAssignmentId(assignmentId);
    }
}
