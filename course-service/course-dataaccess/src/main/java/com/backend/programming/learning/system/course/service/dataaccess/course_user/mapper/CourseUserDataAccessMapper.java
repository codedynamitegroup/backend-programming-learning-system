package com.backend.programming.learning.system.course.service.dataaccess.course_user.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.course.entity.CourseEntity;
import com.backend.programming.learning.system.course.service.dataaccess.course.mapper.CourseDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.course.repository.CourseJpaRepository;
import com.backend.programming.learning.system.course.service.dataaccess.course_user.entity.CourseUserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.entity.CourseUser;
import com.backend.programming.learning.system.valueobject.CourseUserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CourseUserDataAccessMapper {
    private final UserDataAccessMapper userDataAccessMapper;
    private final CourseDataAccessMapper courseDataAccessMapper;
    public CourseUserEntity courseUserToCourseUserEntity(CourseUser courseUser) {
        return CourseUserEntity.builder()
                .id(courseUser.getId().getValue())
                .build();
    }

    public CourseUser courseUserEntityToCourseUser(CourseUserEntity courseUserEntity) {
        return CourseUser.builder()
                .id(new CourseUserId(courseUserEntity.getId()))
                .build();
    }

    public List<CourseUserEntity> courseUserListToCourseUserEntityList(List<CourseUser> courseUsers) {
        return courseUsers.stream()
                .map(this::ToCourseUserEntity)
                .toList();
    }
    public CourseUserEntity ToCourseUserEntity(CourseUser courseUser) {
        UserEntity userEntity = userDataAccessMapper.userToUserEntity(courseUser.user);
        CourseEntity courseEntity = courseDataAccessMapper.courseToCourseEntity(courseUser.course);
        return CourseUserEntity.builder()
                .id(courseUser.getId().getValue())
                .user(userEntity)
                .course(courseEntity)
                .build();
    }
}
