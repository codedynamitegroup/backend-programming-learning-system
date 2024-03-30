package com.backend.programming.learning.system.domain.valueobject;

import java.util.UUID;

public class ReviewId extends BaseId<UUID> {
    public ReviewId(UUID value) {
        super(value);
    }
}
