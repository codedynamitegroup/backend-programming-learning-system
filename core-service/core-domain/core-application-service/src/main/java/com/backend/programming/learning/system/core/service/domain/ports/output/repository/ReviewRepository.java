package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.Review;

public interface ReviewRepository {
    Review saveReview(Review review);
}
