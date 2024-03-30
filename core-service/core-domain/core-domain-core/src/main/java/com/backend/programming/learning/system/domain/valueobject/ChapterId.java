package com.backend.programming.learning.system.domain.valueobject;

import java.util.UUID;

public class ChapterId extends BaseId<UUID> {
    public ChapterId(UUID value) {
        super(value);
    }
}
