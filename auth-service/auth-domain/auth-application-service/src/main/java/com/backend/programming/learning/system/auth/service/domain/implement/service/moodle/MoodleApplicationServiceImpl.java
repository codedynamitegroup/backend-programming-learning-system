package com.backend.programming.learning.system.auth.service.domain.implement.service.moodle;

import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user.UserEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.MoodleApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * com.backend.programming.learning.system.auth.service.domain.implement.service.moodle
 * Create by Dang Ngoc Tien
 * Date 5/2/2024 - 11:49 PM
 * Description: ...
 */
@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class MoodleApplicationServiceImpl implements MoodleApplicationService {
    private final MoodleCommandHandler moodleCommandHandler;
    @Override
    public List<UserEntityResponse> syncUser() {
        return moodleCommandHandler.syncUser();
    }

    @Override
    public String getToken(String username, String password) {
        return moodleCommandHandler.getToken(username, password);
    }
}
