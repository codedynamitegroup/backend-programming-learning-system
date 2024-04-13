package com.backend.programming.learning.system.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class CourseUserId extends BaseId<UUID> {
    public CourseUserId(UUID value) {
        super(value);
    }

}
