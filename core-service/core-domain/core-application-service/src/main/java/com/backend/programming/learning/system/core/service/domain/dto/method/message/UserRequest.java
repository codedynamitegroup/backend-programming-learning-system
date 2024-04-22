package com.backend.programming.learning.system.core.service.domain.dto.method.message;

import com.backend.programming.learning.system.domain.valueobject.UserRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

/***********************************
 * Created by TGT on 31/03/2024.
 * Description: Response from authentication service for main user of auth service
 ************************************/

@Getter
@Builder
@AllArgsConstructor
public class UserRequest {
    private String id;
    private String sagaId;
    private String userId;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String avatarUrl;
    private Instant dob;
    private Instant createdAt;
    private Instant updatedAt;
    private UserRequestStatus userRequestStatus;
    private Boolean isDeleted;
}
