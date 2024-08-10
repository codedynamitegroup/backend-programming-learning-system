package com.backend.programming.learning.system.course.service.dataaccess.course.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.course.entity.CourseEntity;
import com.backend.programming.learning.system.course.service.dataaccess.course.mapper.CourseDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.course.repository.CourseJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CourseRepositoryImpl implements CourseRepository {

    private final CourseJpaRepository courseJpaRepository;
    private final CourseDataAccessMapper courseDataAccessMapper;

    @Override
    public Course save(Course course) {
        try {
            CourseEntity courseEntity = courseDataAccessMapper.courseToCourseEntity(course);
            CourseEntity courseResult=courseJpaRepository.save(courseEntity);
            return courseDataAccessMapper.courseEntityToCourse(courseResult);
        } catch (Exception e) {
            log.error("Error while saving course: {}", e.getMessage());
            throw new RuntimeException("Error while saving course");
        }
    }




    @Override
    public Page<Course> findAll(String search,String[] courseType, Integer page, Integer size) {
        return courseJpaRepository.findAll(search,courseType, PageRequest.of(page, size))
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
    public Page<Course> findAllByOrganizationId(UUID organizationId, String search, String[] courseType, Integer page, Integer size) {
        return
                courseJpaRepository.findAllByOrganizationId(organizationId, search,courseType,PageRequest.of(page, size))
                        .map(courseDataAccessMapper::courseEntityToCourse);
    }

    @Override
    public Optional<Course> findByCourseIdMoodleAndOrganizationId(Integer courseIdMoodle, UUID organizationId) {
        return courseJpaRepository.findByCourseIdMoodleAndOrganizationId(courseIdMoodle,organizationId)
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

    @Override
    public void deleteByMoodleIdAndOrganizationId(Integer courseMoodleId,UUID organizationId) {
        courseJpaRepository.findByCourseIdMoodleAndOrganizationId(courseMoodleId,organizationId)
                .ifPresent(courseJpaRepository::delete);
    }

    @Override
    public Optional<Course> findCourseById(UUID courseId) {
        return courseJpaRepository.findById(courseId)
                .map(courseDataAccessMapper::courseEntityToCourse);
    }
}
