package com.backend.programming.learning.system.core.service.domain.dto.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.Date;
import java.util.List;

/***********************************
 * Created by TGT on 31/03/2024.
 * Description: Response from authentication service for main user of auth service
 ************************************/

@Getter
@Builder
@AllArgsConstructor
public class UserResponse {
    private String id;
    private String sagaId;
    private String userId;
    private String email;
    private String displayName;
    private String avatarUrl;
    private Date dob;
    private Instant createdAt;
    private List<String> failureMessages;
}
