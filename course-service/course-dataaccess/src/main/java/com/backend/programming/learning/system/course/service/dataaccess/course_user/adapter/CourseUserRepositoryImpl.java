package com.backend.programming.learning.system.course.service.dataaccess.course_user.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.course_user.mapper.CourseUserDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.course_user.repository.CourseUserJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.CourseUser;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseUserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class CourseUserRepositoryImpl implements CourseUserRepository {
    private final CourseUserJpaRepository courseUserJpaRepository;
    private final CourseUserDataAccessMapper courseUserDataAccessMapper;

    public CourseUserRepositoryImpl(CourseUserJpaRepository courseUserJpaRepository, CourseUserDataAccessMapper courseUserDataAccessMapper) {
        this.courseUserJpaRepository = courseUserJpaRepository;
        this.courseUserDataAccessMapper = courseUserDataAccessMapper;
    }


    @Override
    public CourseUser saveCourseUser(CourseUser courseUser) {
        return courseUserDataAccessMapper.courseUserEntityToCourseUser(courseUserJpaRepository
                .save(courseUserDataAccessMapper
                        .courseUserToCourseUserEntity(courseUser)));
    }

    @Override
    public void saveAll(List<CourseUser> courseUsers) {
        courseUserJpaRepository.saveAll(courseUserDataAccessMapper.courseUserListToCourseUserEntityList(courseUsers));
    }

    @Override
    public void deleteByCourseIdAndUserIdIn(UUID courseId, List<UUID> userIds) {
        courseUserJpaRepository.deleteByCourseIdAndUserIdIn(courseId, userIds);
    }
}
