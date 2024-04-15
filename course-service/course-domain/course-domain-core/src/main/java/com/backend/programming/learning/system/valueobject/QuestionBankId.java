package com.backend.programming.learning.system.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class QuestionBankId extends BaseId<UUID> {
    public QuestionBankId(UUID value) {
        super(value);
    }
}
