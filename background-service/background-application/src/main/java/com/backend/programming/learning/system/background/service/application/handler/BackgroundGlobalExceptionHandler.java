package com.backend.programming.learning.system.background.service.application.handler;

import com.backend.programming.learning.system.application.handler.ErrorDTO;
import com.backend.programming.learning.system.application.handler.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class BackgroundGlobalExceptionHandler extends GlobalExceptionHandler {

}

