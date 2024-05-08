package com.backend.programming.learning.system.course.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class CourseTypeId extends BaseId<UUID> {
    public CourseTypeId(UUID value) {
        super(value);
    }
}
