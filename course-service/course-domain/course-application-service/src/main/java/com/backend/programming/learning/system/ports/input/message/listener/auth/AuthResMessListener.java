package com.backend.programming.learning.system.ports.input.message.listener.auth;


import com.backend.programming.learning.system.dto.message.UserAuthResponse;

/***********************************
 * Created by TGT on 31/03/2024.
 * Description: listen to response from authentication service for auth
 * including all table from auth service like user, role, organization, etc
 ************************************/

public interface AuthResMessListener {
    void userUpdated(UserAuthResponse userAuthResponse);
    void userCreated(UserAuthResponse userAuthResponse);
    void userDeleted(UserAuthResponse userAuthResponse);
}