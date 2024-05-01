package com.backend.programming.learning.system.code.assessment.service.application.exception.handler;

import com.backend.programming.learning.system.application.handler.ErrorDTO;
import com.backend.programming.learning.system.application.handler.GlobalExceptionHandler;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.CodeAssessmentDomainException;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.code_question.CodeQuestionNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.code_submission.CodeSubmissionJudgingServiceUnavailableException;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.programming_language.ProgrammingLanguageNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.test_case.TestCaseNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.GradingStatus;
import com.backend.programming.learning.system.domain.exception.question.QuestionNotFoundException;
import com.backend.programming.learning.system.domain.exception.user.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
@Slf4j
public class CodeAssessmentGlobalExceptionHandler extends GlobalExceptionHandler {
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {CodeAssessmentDomainException.class})
    public ErrorDTO handleException(CodeAssessmentDomainException codeAssessmentDomainException){
        log.error(codeAssessmentDomainException.getMessage(), codeAssessmentDomainException);
        return ErrorDTO.builder()
                .message(codeAssessmentDomainException.getMessage())
                .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
    }
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {QuestionNotFoundException.class})
    public ErrorDTO handleException(QuestionNotFoundException questionNotFoundException){
        log.error(questionNotFoundException.getMessage(), questionNotFoundException);
        return ErrorDTO.builder()
                .message(questionNotFoundException.getMessage())
                .status(HttpStatus.NOT_FOUND.getReasonPhrase())
                .code(HttpStatus.NOT_FOUND.value())
                .build();
    }
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {TestCaseNotFoundException.class})
    public ErrorDTO handleException(TestCaseNotFoundException exception){
        log.error(exception.getMessage(), exception);
        return ErrorDTO.builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND.getReasonPhrase())
                .code(HttpStatus.NOT_FOUND.value())
                .build();
    }
    @ResponseBody
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(value = {CodeSubmissionJudgingServiceUnavailableException.class})
    public ErrorDTO handleException(CodeSubmissionJudgingServiceUnavailableException exception){
        log.error(exception.getMessage(), exception);
        return ErrorDTO.builder()
                .message(GradingStatus.GRADING_SYSTEM_UNAVAILABLE.name() + ": " + exception.getMessage())
                .status(HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase())
                .code(HttpStatus.SERVICE_UNAVAILABLE.value())
                .build();
    }
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {ProgrammingLanguageNotFoundException.class})
    public ErrorDTO handleException(ProgrammingLanguageNotFoundException exception){
        log.error(exception.getMessage(), exception);
        return ErrorDTO.builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND.getReasonPhrase())
                .code(HttpStatus.NOT_FOUND.value())
                .build();
    }
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {CodeQuestionNotFoundException.class})
    public ErrorDTO handleException(CodeQuestionNotFoundException exception){
        log.error(exception.getMessage(), exception);
        return ErrorDTO.builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND.getReasonPhrase())
                .code(HttpStatus.NOT_FOUND.value())
                .build();
    }
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {UserNotFoundException.class})
    public ErrorDTO handleException(UserNotFoundException exception){
        log.error(exception.getMessage(), exception);
        return ErrorDTO.builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND.getReasonPhrase())
                .code(HttpStatus.NOT_FOUND.value())
                .build();
    }
}
