package com.backend.programming.learning.system.course.service.domain.implement.service.course_type;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.course_type.QueryCourseTypeCommand;
import com.backend.programming.learning.system.course.service.domain.entity.CourseType;
import com.backend.programming.learning.system.course.service.domain.exception.CourseDomainException;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class CourseTypeQueryHelper {
    private final CourseTypeRepository courseTypeRepository;

    @Transactional(readOnly = true)
    public List<CourseType> findAll() {
        List<CourseType> courseTypes = courseTypeRepository.findAll();
        log.info("Course types found successfully");
        return courseTypes;
    }

    @Transactional(readOnly = true)
    public CourseType findById(UUID courseTypeId) {
        Optional<CourseType> courseType = courseTypeRepository.findById(courseTypeId);
        if (courseType.isEmpty()) {
            log.warn("Course type with id: {} not found", courseTypeId);
            throw new CourseDomainException("Course type not found");
        }
        return courseType.get();
    }
    @Transactional(readOnly = true)
    public Page<CourseType> findAllByOrganizationId(QueryCourseTypeCommand queryCourseTypeCommand) {
        Page<CourseType> courseTypes = courseTypeRepository.findAllByOrganizationId(
                queryCourseTypeCommand.getOrganizationId(),
                queryCourseTypeCommand.getPageNo(),
                queryCourseTypeCommand.getPageSize(),
                queryCourseTypeCommand.getSearchName());
        log.info("Course types found successfully");
        return courseTypes;
    }
}
