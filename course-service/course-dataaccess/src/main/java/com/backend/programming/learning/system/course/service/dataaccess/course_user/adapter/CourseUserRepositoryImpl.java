package com.backend.programming.learning.system.course.service.dataaccess.course_user.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.course_user.mapper.CourseUserDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.course_user.repository.CourseUserJpaRepository;
import com.backend.programming.learning.system.entity.CourseUser;
import com.backend.programming.learning.system.ports.output.repository.CourseUserRepository;
import org.springframework.stereotype.Repository;

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
}
