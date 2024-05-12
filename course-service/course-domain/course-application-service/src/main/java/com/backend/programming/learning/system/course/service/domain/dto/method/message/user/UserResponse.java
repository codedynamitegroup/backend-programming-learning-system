package com.backend.programming.learning.system.course.service.domain.dto.method.message.user;

import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class UserResponse {
    private String id;
    private String sagaId;
    private String userId;
    private CopyState state;
    private ServiceName serviceName;
    private List<String> failureMessages;
}
