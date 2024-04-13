package com.backend.programming.learning.system.course.service.application.rest.course;

import com.backend.programming.learning.system.course.service.domain.dto.course.create.CreateCourseCommand;
import com.backend.programming.learning.system.course.service.domain.dto.course.create.CreateCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.course.get.CourseResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.course.CourseApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.backend.programming.learning.system.course.service.application.rest.course
 * Create by Dang Ngoc Tien
 * Date 4/10/2024 - 10:26 PM
 * Description: ...
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/course", produces = "application/vnd.api.v1+json")
public class CourseController {
    private final CourseApplicationService courseApplicationService;
    @GetMapping
    public ResponseEntity<CourseResponse> findAll(
            @RequestParam(value = "search", required = false) String search
    ) {
        log.info("Getting list course");
        CourseResponse response = courseApplicationService.findAll(search);
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<CreateCourseResponse> createCourse(
            @RequestBody CreateCourseCommand createCourseCommand
    ) {
        log.info("Creating course");
        CreateCourseResponse response = courseApplicationService.createCourse(createCourseCommand);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{courseId}")
    public ResponseEntity<CreateCourseResponse> findBy(@PathVariable Long courseId) {
        log.info("Getting course with id: {}", courseId);
        CreateCourseResponse response = courseApplicationService.findBy(courseId);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteBy(@PathVariable Long courseId) {
        log.info("Deleting course with id: {}", courseId);
        courseApplicationService.deleteBy(courseId);
        return ResponseEntity.noContent().build();
    }
}
