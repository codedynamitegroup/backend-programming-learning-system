package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.valueobject.CourseId;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class Course extends AggregateRoot<CourseId> {
    private String name;
    private String key;
    private Boolean visible;
    private User createdBy;
    private List<Post> posts;
    private List<Exam> exams;
    private List<Assignment> assignments;
    private User updatedBy;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public void initializeCourse() {
        setId(new CourseId(UUID.randomUUID()));
        createdAt = ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM));
        updatedAt = ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM));
    }
}
