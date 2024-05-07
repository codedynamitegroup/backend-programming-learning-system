package com.backend.programming.learning.system.auth.service.domain.dto.method.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseLoginAndRefreshUser {
    String access_token;
    Integer expires_in;
    Integer refresh_expires_in;
    String refresh_token;
    String token_type;
    String session_state;
    String scope;
}
