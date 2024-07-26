package com.backend.programming.learning.system.course.service.dataaccess.course_user.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.course.entity.CourseEntity;
import com.backend.programming.learning.system.course.service.dataaccess.course.mapper.CourseDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.course_user.entity.CourseUserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.role_moodle.entity.RoleMoodleEntity;
import com.backend.programming.learning.system.course.service.dataaccess.role_moodle.mapper.RoleMoodleDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.CourseUser;
import com.backend.programming.learning.system.course.service.domain.entity.RoleMoodle;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseUserId;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CourseUserDataAccessMapper {
    private final UserDataAccessMapper userDataAccessMapper;
    private final CourseDataAccessMapper courseDataAccessMapper;
    private final RoleMoodleDataAccessMapper roleMoodleDataAccessMapper;
    public CourseUserEntity courseUserToCourseUserEntity(CourseUser courseUser) {
        return CourseUserEntity.builder()
                .id(courseUser.getId().getValue())
                .user(userDataAccessMapper.userToUserEntity(courseUser.getUser()))
                .course(courseDataAccessMapper.courseToCourseEntity(courseUser.getCourse()))
                .roleMoodle(roleMoodleDataAccessMapper.roleMoodleToRoleMoodleEntity(courseUser.getRoleMoodle()))
                .createdAt(courseUser.getCreatedAt())
                .build();
    }

    public CourseUser courseUserEntityToCourseUser(CourseUserEntity courseUserEntity) {
        User user = userDataAccessMapper.userEntityToUser(courseUserEntity.getUser());
        Course course = courseDataAccessMapper.courseEntityToCourse(courseUserEntity.getCourse());
        RoleMoodle roleMoodle = roleMoodleDataAccessMapper.roleMoodleEntityToRoleMoodle(courseUserEntity.getRoleMoodle());
        return CourseUser.builder()
                .id(new CourseUserId(courseUserEntity.getId()))
                .user(user)
                .course(course)
                .roleMoodle(roleMoodle)
                .createdAt(courseUserEntity.getCreatedAt())
                .build();
    }

    public List<CourseUserEntity> courseUserListToCourseUserEntityList(List<CourseUser> courseUsers) {
        return courseUsers.stream()
                .map(this::ToCourseUserEntity)
                .toList();
    }
    public CourseUserEntity ToCourseUserEntity(CourseUser courseUser) {
        UserEntity userEntity = userDataAccessMapper.userToUserEntity(courseUser.getUser());
        CourseEntity courseEntity = courseDataAccessMapper.courseToCourseEntity(courseUser.getCourse());
        RoleMoodleEntity roleMoodleEntity = roleMoodleDataAccessMapper.roleMoodleToRoleMoodleEntity(courseUser.getRoleMoodle());

        return CourseUserEntity.builder()
                .id(courseUser.getId().getValue())
                .user(userEntity)
                .course(courseEntity)
                .roleMoodle(roleMoodleEntity)
                .createdAt(courseUser.getCreatedAt())
                .build();
    }

    public List<CourseUser> courseUserToCourseUserEntityList(List<CourseUserEntity> byCourseId) {
        return byCourseId.stream()
                .map(this::courseUserEntityToCourseUser)
                .toList();
    }

    public Page<CourseUser> courseUserPageToCourseUserPage(Page<CourseUserEntity> allUserByCourseId) {
        return allUserByCourseId.map(this::courseUserEntityToCourseUser);
    }
}
