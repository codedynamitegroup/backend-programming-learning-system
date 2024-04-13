package com.backend.programming.learning.system.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class QuestionBankEntriesId extends BaseId<UUID> {
    public QuestionBankEntriesId(UUID value) {
        super(value);
    }
}
