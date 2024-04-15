package com.backend.programming.learning.system.core.service.domain.event;

import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.domain.event.DomainEvent;

import java.time.ZonedDateTime;

public abstract class ReviewEvent implements DomainEvent<Review> {
    private final Review review;
    private final ZonedDateTime createdAt;

    public ReviewEvent(Review review, ZonedDateTime createdAt) {
        this.review = review;
        this.createdAt = createdAt;
    }

    public Review getCertificateCourseReview() {
        return review;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
