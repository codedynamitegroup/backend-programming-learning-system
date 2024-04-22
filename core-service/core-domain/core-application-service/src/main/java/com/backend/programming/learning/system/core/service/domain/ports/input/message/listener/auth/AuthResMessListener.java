package com.backend.programming.learning.system.core.service.domain.ports.input.message.listener.auth;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.UserRequest;

/***********************************
 * Created by TGT on 31/03/2024.
 * Description: listen to response from authentication service for auth
 * including all table from auth service like user, role, organization, etc
 ************************************/

public interface AuthResMessListener {
    void userUpdated(UserRequest userAuthResponse);
    void userCreated(UserRequest userAuthResponse);
    void userDeleted(UserRequest userAuthResponse);
}