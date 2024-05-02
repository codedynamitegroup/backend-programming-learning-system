package com.backend.programming.learning.system.auth.service.domain.ports.input.service;

import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user.UserEntityResponse;

import java.util.List;

/**
 * com.backend.programming.learning.system.auth.service.domain.ports.input.service
 * Create by Dang Ngoc Tien
 * Date 5/2/2024 - 11:46 PM
 * Description: ...
 */
public interface MoodleApplicationService {
    List<UserEntityResponse> syncUser();
}
