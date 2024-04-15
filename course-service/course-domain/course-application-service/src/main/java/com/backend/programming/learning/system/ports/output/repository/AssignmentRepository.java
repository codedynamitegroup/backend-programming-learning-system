package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.Assignment;

public interface AssignmentRepository {
    Assignment saveAssignment(Assignment assignment);
}
