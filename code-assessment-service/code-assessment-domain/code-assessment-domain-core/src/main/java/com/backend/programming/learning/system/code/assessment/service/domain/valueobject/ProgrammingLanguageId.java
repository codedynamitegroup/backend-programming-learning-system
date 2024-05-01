package com.backend.programming.learning.system.code.assessment.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class ProgrammingLanguageId extends BaseId<UUID> {
    public ProgrammingLanguageId(UUID value) {
        super(value);
    }
}
