package com.backend.programming.learning.system.core.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class ReviewId extends BaseId<UUID> {
    public ReviewId(UUID value) {
        super(value);
    }
}
