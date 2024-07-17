package com.backend.programming.learning.system.course.service.dataaccess.course_type.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.course_type.mapper.CourseTypeDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.course_type.repository.CourseTypeJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.CourseType;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CourseTypeRepositoryImpl implements CourseTypeRepository {

    private final CourseTypeJpaRepository courseJpaRepository;
    private final CourseTypeDataAccessMapper courseTypeDataAccessMapper;


    @Override
    public CourseType save(CourseType courseType) {
        return courseTypeDataAccessMapper.courseTypeEntityToCourseType(courseJpaRepository
                .saveAndFlush(courseTypeDataAccessMapper
                        .courseTypeToCourseTypeEntity(courseType)));
    }

    @Override
    public Optional<CourseType> findById(UUID courseType) {
        return
                courseJpaRepository.findById(courseType)
                        .map(courseTypeDataAccessMapper::courseTypeEntityToCourseType);
    }

    @Override
    public Page<CourseType> findAll(String search, Pageable pageable) {
        return courseJpaRepository.findAll(search, pageable)
                .map(courseTypeDataAccessMapper::courseTypeEntityToCourseType);
    }

    @Override
    public void deleteCourseTypeById(UUID courseTypeId) {
        courseJpaRepository.deleteById(courseTypeId);
    }

    @Override
    public List<CourseType> findAll() {
        return courseTypeDataAccessMapper.courseTypeEntityListToCourseTypeList(courseJpaRepository.findAll());
    }

    @Override
    public Optional<CourseType> findByMoodleId(Integer moodleId) {
        return courseJpaRepository.findByMoodleId(moodleId)
                .map(courseTypeDataAccessMapper::courseTypeEntityToCourseType);
    }

    @Override
    public Page<CourseType> findAllByOrganizationId(UUID organizationId, Integer page, Integer size, String searchName) {
        Pageable paging = PageRequest.of(page, size);
        return courseJpaRepository.findAllByOrganizationId(organizationId, paging, searchName)
                .map(courseTypeDataAccessMapper::courseTypeEntityToCourseType);
    }
}
