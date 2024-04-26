package com.backend.programming.learning.system.course.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class CourseId extends BaseId<UUID> {
    public CourseId(UUID value) {
        super(value);
    }
}
