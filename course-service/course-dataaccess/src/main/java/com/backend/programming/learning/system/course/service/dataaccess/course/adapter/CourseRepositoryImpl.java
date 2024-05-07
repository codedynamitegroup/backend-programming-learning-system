package com.backend.programming.learning.system.course.service.dataaccess.course.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.course.mapper.CourseDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.course.repository.CourseJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CourseRepositoryImpl implements CourseRepository {

    private final CourseJpaRepository courseJpaRepository;
    private final CourseDataAccessMapper courseDataAccessMapper;

    @Override
    public Course save(Course course) {
        return courseDataAccessMapper.courseEntityToCourse(courseJpaRepository
                .saveAndFlush(courseDataAccessMapper
                        .courseToCourseEntity(course)));
    }

    @Override
    public Page<Course> findAll(String search, Integer page, Integer size) {
        return courseJpaRepository.findAll(search, PageRequest.of(page, size))
                .map(courseDataAccessMapper::courseEntityToCourse);
    }

    @Override
    public Course findBy(UUID courseId) {
        return courseDataAccessMapper.courseEntityToCourse(courseJpaRepository
                .findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found")));
    }

    @Override
    public Optional<Course> findByName(String courseName) {
        return courseJpaRepository.findByName(courseName)
                .map(courseDataAccessMapper::courseEntityToCourse);
    }

    @Override
    public Course findById(UUID courseId) {
        return courseDataAccessMapper.courseEntityToCourse(courseJpaRepository
                .findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found")));
    }

    @Override
    public void deleteById(UUID courseId) {
        courseJpaRepository.deleteById(courseId);
    }
}
