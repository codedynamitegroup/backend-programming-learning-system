package com.backend.programming.learning.system.code.assessment.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class TestCaseId extends BaseId<UUID> {
    public TestCaseId(UUID value) {
        super(value);
    }
}
