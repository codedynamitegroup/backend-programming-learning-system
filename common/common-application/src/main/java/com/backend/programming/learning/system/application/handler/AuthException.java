package com.backend.programming.learning.system.application.handler;

public class AuthException extends RuntimeException{
    public AuthException(String message) {super(message);}
    public AuthException(String message, Throwable cause) {
        super(message, cause);
    }

}
