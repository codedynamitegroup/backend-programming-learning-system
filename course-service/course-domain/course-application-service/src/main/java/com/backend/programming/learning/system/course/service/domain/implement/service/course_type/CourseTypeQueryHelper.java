package com.backend.programming.learning.system.course.service.domain.implement.service.course_type;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.course_type.QueryCourseTypeCommand;
import com.backend.programming.learning.system.course.service.domain.entity.CourseType;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class CourseTypeQueryHelper {
    private final CourseTypeRepository courseTypeRepository;

    public List<CourseType> findAll() {
        List<CourseType> courseTypes = courseTypeRepository.findAll();
        log.info("Course types found successfully");
        return courseTypes;
    }

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
