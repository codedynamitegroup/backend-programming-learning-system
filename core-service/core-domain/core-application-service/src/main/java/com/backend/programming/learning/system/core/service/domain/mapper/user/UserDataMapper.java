package com.backend.programming.learning.system.core.service.domain.mapper.user;

import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.review.QueryReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.user.QueryUserResponse;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class UserDataMapper {

    public QueryUserResponse userToQueryUserResponse(User user) {
        return QueryUserResponse.builder()
                .userId(user.getId().getValue())
                .email(user.getEmail())
                .build();
    }
}
