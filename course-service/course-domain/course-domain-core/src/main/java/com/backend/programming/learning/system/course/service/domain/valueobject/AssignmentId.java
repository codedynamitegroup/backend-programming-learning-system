package com.backend.programming.learning.system.course.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.rmi.server.UID;
import java.util.UUID;

public class AssignmentId extends BaseId<UUID> {
    public AssignmentId(UUID value) {
        super(value);
    }
}
