package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.dto.method.update.user.UpdateUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.user.UpdateUserResponse;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    User save(User user);

    Optional<User> findUser(UUID userId);

    Optional<User> findUserByEmail(String email);

    Optional<User> findByUserIdMoodle(Integer userIdMoodle);

    List<User> findAll();

    List<User> findAllUserByAssignmentId(UUID assignmentId);

    Optional<User> findByEmail(String email);

    Optional<User> findById(UserId userId);

    void deleteByUserMoodleId(Integer userIdMoodle);

    Page<User> findAllByCourseId(UUID courseId, Integer page, Integer size, String searchName);


}
