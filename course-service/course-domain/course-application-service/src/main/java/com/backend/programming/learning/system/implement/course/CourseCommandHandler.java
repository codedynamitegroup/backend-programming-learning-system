package com.backend.programming.learning.system.implement.course;

import com.backend.programming.learning.system.dto.method.create.course.CreateCourseCommand;
import com.backend.programming.learning.system.dto.method.create.course.CreateCourseResponse;
import com.backend.programming.learning.system.dto.method.query.course.QueryAllCourseCommand;
import com.backend.programming.learning.system.dto.method.query.course.QueryAllCourseResponse;
import com.backend.programming.learning.system.dto.method.query.course.QueryCourseCommand;
import com.backend.programming.learning.system.dto.responseentity.course.CourseResponseEntity;
import com.backend.programming.learning.system.entity.Course;
import com.backend.programming.learning.system.mapper.course.CourseDataMapper;
import com.backend.programming.learning.system.ports.output.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 * com.backend.programming.learning.system.implemtent.course
 * Create by Dang Ngoc Tien
 * Date 4/17/2024 - 2:15 AM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CourseCommandHandler {
    private final CourseCreateHelper courseCreateHelper;
    private final CourseQueryHelper courseQueryHelper;
    private final CourseDataMapper courseDataMapper;
    private final CourseRepository courseRepository;

    public CreateCourseResponse createCourse(CreateCourseCommand createCourseCommand) {
        Course course = courseCreateHelper.createCourse(createCourseCommand);
        log.info("Course is created with id: {}", course.getId());
        return courseDataMapper.courseToCreateCourseResponse(course, "Course created successfully");
    }

    @Transactional(readOnly = true)
    public QueryAllCourseResponse findAll(QueryAllCourseCommand queryAllCourseCommand) {
        Page<Course> courses = courseQueryHelper.findAll(
                queryAllCourseCommand.getSearch(),
                queryAllCourseCommand.getPageNo(),
                queryAllCourseCommand.getPageSize());
        log.info("Returning all courses: {}", courses);
        return courseDataMapper.coursesToQueryAllCourseResponse(courses);
    }

    @Transactional(readOnly = true)
    public CourseResponseEntity findBy(QueryCourseCommand queryCourseCommand) {
        Course course = courseQueryHelper.findById(queryCourseCommand.getCourseId());
        log.info("Returning course: {}", course);
        return courseDataMapper.courseToQueryCourseResponse(course);
    }
}