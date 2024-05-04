package com.backend.programming.learning.system.course.service.dataaccess.course_user.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.course.entity.CourseEntity;
import com.backend.programming.learning.system.course.service.dataaccess.course.mapper.CourseDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.course_user.entity.CourseUserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.course.service.domain.entity.CourseUser;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseUserId;
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
                .user(userDataAccessMapper.userToUserEntity(courseUser.user))
                .course(courseDataAccessMapper.courseToCourseEntity(courseUser.course))
                .build();
    }

    public CourseUser courseUserEntityToCourseUser(CourseUserEntity courseUserEntity) {
        return CourseUser.builder()
                .id(new CourseUserId(courseUserEntity.getId()))
                .user(userDataAccessMapper.userEntityToUser(courseUserEntity.getUser()))
                .course(courseDataAccessMapper.courseEntityToCourse(courseUserEntity.getCourse()))
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
