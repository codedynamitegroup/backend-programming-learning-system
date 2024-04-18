package com.backend.programming.learning.system.auth.service.application.rest.course;

import com.backend.programming.learning.system.dto.method.create.course.CreateCourseCommand;
import com.backend.programming.learning.system.dto.method.create.course.CreateCourseResponse;
import com.backend.programming.learning.system.dto.method.query.course.QueryAllCourseCommand;
import com.backend.programming.learning.system.dto.method.query.course.QueryAllCourseResponse;
import com.backend.programming.learning.system.dto.method.query.course.QueryCourseCommand;
import com.backend.programming.learning.system.dto.responseentity.course.CourseResponseEntity;
import com.backend.programming.learning.system.ports.input.service.course.CourseApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.auth.service.application.rest
 * Create by Dang Ngoc Tien
 * Date 4/17/2024 - 1:50 AM
 * Description: ...
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/course/course", produces = "application/vnd.api.v1+json")
public class CourseController {
    private final CourseApplicationService courseApplicationService;

    @PostMapping("/create")
    public ResponseEntity<CreateCourseResponse> createCourse(
            @RequestBody CreateCourseCommand createCourseCommand) {
        log.info("Creating course: {}", createCourseCommand);
        CreateCourseResponse response = courseApplicationService.createCourse(createCourseCommand);
        log.info("Course created: {}", response);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<QueryAllCourseResponse> findAll(
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        log.info("Getting list course");
        QueryAllCourseCommand queryAllCourseCommand = QueryAllCourseCommand.builder()
                .search(search)
                .pageNo(pageNo)
                .pageSize(pageSize)
                .build();

        QueryAllCourseResponse response = courseApplicationService.findAll(queryAllCourseCommand);
        log.info("Returning all courses: {}", response);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseResponseEntity> findBy(@PathVariable UUID courseId) {
        log.info("Getting course with id: {}", courseId);
        QueryCourseCommand queryCourseCommand = QueryCourseCommand.builder().courseId(courseId).build();
        CourseResponseEntity response = courseApplicationService.findBy(queryCourseCommand);
        return ResponseEntity.ok(response);
    }
}
