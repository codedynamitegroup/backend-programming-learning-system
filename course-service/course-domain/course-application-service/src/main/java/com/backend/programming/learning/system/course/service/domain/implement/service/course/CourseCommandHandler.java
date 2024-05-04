package com.backend.programming.learning.system.course.service.domain.implement.service.course;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.course.CreateCourseCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.course.CreateCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.course.DeleteCourseCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.course.DeleteCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course.QueryAllCourseCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course.QueryAllCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course.QueryCourseCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.course.UpdateCourseCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.course.UpdateCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course.CourseResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.mapper.course.CourseDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
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
    private final CourseDeleteHelper courseDeleteHelper;
    private final CourseUpdateHelper courseUpdateHelper;
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

    @Transactional
    public DeleteCourseResponse deleteCourse(DeleteCourseCommand deleteCourseCommand) {
        courseDeleteHelper.deleteCourse(deleteCourseCommand.courseId());
        log.info("Course is deleted successfully");
        return DeleteCourseResponse.builder()
                .message("Course is deleted successfully")
                .build();
    }

    @Transactional
    public UpdateCourseResponse updateCourse(CourseId courseId, UpdateCourseCommand updateCourseCommand) {
        Course course = courseUpdateHelper.updateCourse(courseId, updateCourseCommand);
        log.info("Course is updated with id: {}", course.getId());
        return courseDataMapper.courseToUpdateCourseResponse(course, "Course is updated successfully");
    }
}
