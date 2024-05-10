package com.backend.programming.learning.system.course.service.domain.ports.output.repository;
import com.backend.programming.learning.system.course.service.domain.entity.CourseType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseTypeRepository {
    CourseType save(CourseType courseType);

    Optional<CourseType> findById(UUID courseType);

    Page<CourseType> findAll(String search, Pageable pageable);

    void deleteCourseTypeById(UUID courseTypeId);

    List<CourseType> findAll();
    Optional<CourseType> findByMoodleId(Integer moodleId);
}
