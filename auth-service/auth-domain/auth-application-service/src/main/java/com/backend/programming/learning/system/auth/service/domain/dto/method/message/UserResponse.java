package com.backend.programming.learning.system.auth.service.domain.dto.method.message;

import com.backend.programming.learning.system.domain.valueobject.CopyState;
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
    private List<String> failureMessages;
}
