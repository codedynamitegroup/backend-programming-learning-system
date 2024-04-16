package com.backend.programming.learning.system.course.service.dataaccess.course.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.course.mapper.CourseDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.course.repository.CourseJpaRepository;
import com.backend.programming.learning.system.entity.Course;
import com.backend.programming.learning.system.ports.output.repository.CourseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

    private final CourseJpaRepository courseJpaRepository;
    private final CourseDataAccessMapper courseDataAccessMapper;

    public CourseRepositoryImpl(CourseJpaRepository courseJpaRepository, CourseDataAccessMapper courseDataAccessMapper) {
        this.courseJpaRepository = courseJpaRepository;
        this.courseDataAccessMapper = courseDataAccessMapper;
    }
    @Override
    public Course saveCourse(Course course) {
        return courseDataAccessMapper.courseEntityToCourse(courseJpaRepository
                .save(courseDataAccessMapper
                        .courseToCourseEntity(course)));
    }

    @Override
    public Course save(Course course) {
        return courseDataAccessMapper.courseEntityToCourse(courseJpaRepository
                .save(courseDataAccessMapper
                        .courseToCourseEntity(course)));
    }

    @Override
    public List<Course> findAll(String search) {
        return courseJpaRepository.findAll() // chưa search and paging
                .stream()
                .map(courseDataAccessMapper::courseEntityToCourse)
                .toList();
    }

    @Override
    public Course findBy(UUID courseId) {
        return courseDataAccessMapper.courseEntityToCourse(courseJpaRepository
                .findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found")));
    }

}
