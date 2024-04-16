package com.backend.programming.learning.system.dto.create;

import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateCourseResponse {
    private UUID id;
    private String name;
//    private String key;
    private Boolean visible;
    private UserId createdBy;
//    private List<Post> posts;
//    private List<Exam> exams;
//    private List<Assignment> assignments;
    private UserId updatedBy;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    @NotNull
    private final String message;
}
