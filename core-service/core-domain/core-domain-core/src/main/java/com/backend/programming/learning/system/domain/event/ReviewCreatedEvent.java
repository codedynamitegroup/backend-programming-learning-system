package com.backend.programming.learning.system.domain.event;

import com.backend.programming.learning.system.domain.entity.Review;

import java.time.ZonedDateTime;

public class ReviewCreatedEvent extends ReviewEvent {

    public ReviewCreatedEvent(Review review, ZonedDateTime createdAt) {
        super(review, createdAt);
    }
}
