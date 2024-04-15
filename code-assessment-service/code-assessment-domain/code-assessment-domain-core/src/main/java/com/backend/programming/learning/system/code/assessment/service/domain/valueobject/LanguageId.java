package com.backend.programming.learning.system.code.assessment.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class LanguageId extends BaseId<UUID> {
    public LanguageId(UUID value) {
        super(value);
    }
}
