package com.backend.programming.learning.system.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.rmi.server.UID;
import java.util.UUID;

public class ExamId extends BaseId<UUID> {
    public ExamId(UUID value) {
        super(value);
    }
}
